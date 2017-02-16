/**
 * Copyright (C) 2009-2017 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.remote.serialization

import akka.serialization.{ BaseSerializer, SerializationExtension, SerializerWithStringManifest }
import akka.protobuf.ByteString
import com.typesafe.config.{ Config, ConfigFactory }
import akka.actor.{ Deploy, ExtendedActorSystem, NoScopeGiven, Props, Scope }
import akka.remote.DaemonMsgCreate
import akka.remote.WireFormats.{ DaemonMsgCreateData, DeployData, PropsData, SerializedMessage }
import akka.routing.{ NoRouter, RouterConfig }

import scala.reflect.ClassTag
import util.{ Failure, Success }
import java.io.Serializable

/**
 * Serializes Akka's internal DaemonMsgCreate using protobuf
 * for the core structure of DaemonMsgCreate, Props and Deploy.
 * Serialization of contained RouterConfig, Config, and Scope
 * is done with configured serializer for those classes, by
 * default java.io.Serializable.
 *
 * INTERNAL API
 */
private[akka] final class DaemonMsgCreateSerializer(val system: ExtendedActorSystem) extends BaseSerializer {
  import ProtobufSerializer.serializeActorRef
  import ProtobufSerializer.deserializeActorRef
  import Deploy.NoDispatcherGiven

  private val scala212OrLater = !scala.util.Properties.versionNumberString.startsWith("2.11")

  private lazy val serialization = SerializationExtension(system)

  override val includeManifest: Boolean = false

  def toBinary(obj: AnyRef): Array[Byte] = obj match {
    case DaemonMsgCreate(props, deploy, path, supervisor) ⇒

      def deployProto(d: Deploy): DeployData = {
        val builder = DeployData.newBuilder.setPath(d.path)
        if (d.config != ConfigFactory.empty)
          builder.setConfig(oldSerialize(d.config))
        if (d.routerConfig != NoRouter)
          builder.setRouterConfig(oldSerialize(d.routerConfig))
        if (d.scope != NoScopeGiven)
          builder.setScope(oldSerialize(d.scope))
        if (d.dispatcher != NoDispatcherGiven)
          builder.setDispatcher(d.dispatcher)
        builder.build
      }

      def propsProto = {
        val builder = PropsData.newBuilder
          .setClazz(props.clazz.getName)
          .setDeploy(deployProto(props.deploy))
        props.args.foreach { arg ⇒
          val (serializerId, hasManifest, manifest, bytes) = serialize(arg)
          builder.addArgs(ByteString.copyFrom(bytes))
          builder.addClasses(manifest)
          builder.addSerializerIds(serializerId)
          builder.addHasManifest(hasManifest)
        }
        builder.build
      }

      DaemonMsgCreateData.newBuilder.
        setProps(propsProto).
        setDeploy(deployProto(deploy)).
        setPath(path).
        setSupervisor(serializeActorRef(supervisor)).
        build.toByteArray

    case _ ⇒
      throw new IllegalArgumentException(
        "Can't serialize a non-DaemonMsgCreate message using DaemonMsgCreateSerializer [%s]".format(obj))
  }

  def fromBinary(bytes: Array[Byte], clazz: Option[Class[_]]): AnyRef = {
    val proto = DaemonMsgCreateData.parseFrom(bytes)

    def deploy(protoDeploy: DeployData): Deploy = {
      val config =
        if (protoDeploy.hasConfig) oldDeserialize(protoDeploy.getConfig, classOf[Config])
        else ConfigFactory.empty
      val routerConfig =
        if (protoDeploy.hasRouterConfig) oldDeserialize(protoDeploy.getRouterConfig, classOf[RouterConfig])
        else NoRouter
      val scope =
        if (protoDeploy.hasScope) oldDeserialize(protoDeploy.getScope, classOf[Scope])
        else NoScopeGiven
      val dispatcher =
        if (protoDeploy.hasDispatcher) protoDeploy.getDispatcher
        else NoDispatcherGiven
      Deploy(protoDeploy.getPath, config, routerConfig, scope, dispatcher)
    }

    def props = {
      import scala.collection.JavaConverters._
      val protoProps = proto.getProps
      val actorClass = system.dynamicAccess.getClassFor[AnyRef](protoProps.getClazz).get
      val args: Vector[AnyRef] =
        if (protoProps.getSerializerIdsCount > 0) {
          // message from a 2.5+ node, which (may) includes string manifest and serializer id
          for {
            idx ← (0 until protoProps.getSerializerIdsCount).toVector
          } yield {
            val manifest = protoProps.getClasses(idx)
            // we have info per position if a string manifest serializer was used or not
            if (protoProps.getHasManifest(idx)) {
              serialization.deserializeByteBuffer(
                protoProps.getArgs(idx).asReadOnlyByteBuffer(),
                protoProps.getSerializerIds(idx), manifest)
            } else {
              oldDeserialize(protoProps.getArgs(idx), protoProps.getClasses(idx))
            }
          }
        } else {
          // message from an older node, which only provides data and class name
          (proto.getProps.getArgsList.asScala zip proto.getProps.getClassesList.asScala)
            .map(oldDeserialize)(collection.breakOut)
        }
      Props(deploy(proto.getProps.getDeploy), actorClass, args)
    }

    DaemonMsgCreate(
      props = props,
      deploy = deploy(proto.getDeploy),
      path = proto.getPath,
      supervisor = deserializeActorRef(system, proto.getSupervisor))
  }

  private def oldSerialize(any: Any): ByteString = ByteString.copyFrom(serialization.serialize(any.asInstanceOf[AnyRef]).get)

  private def serialize(any: Any): (Int, Boolean, String, Array[Byte]) = {
    val m = any.asInstanceOf[AnyRef]
    val serializer = serialization.findSerializerFor(m)

    // this trixery is to retain backwards wire compatibility while at the same time
    // allowing for usage of string manifests when enable-additional-serialization-bindings = on
    var hasManifest = false
    val manifest = serializer match {
      case ser: SerializerWithStringManifest ⇒
        hasManifest = true
        ser.manifest(m)
      case _ if m eq null ⇒ "null"
      case _ ⇒
        val className = m.getClass.getName
        if (scala212OrLater && m.isInstanceOf[Serializable] && m.getClass.isSynthetic && className.contains("$Lambda$")) {
          // When the additional-protobuf serializers are not enabled
          // the serialization of the parameters is based on passing class name instead of
          // serializerId and manifest as we usually do. With Scala 2.12 the functions are generated as
          // lambdas and we can't use that load class from that name when deserializing
          classOf[Serializable].getName
        } else {
          className
        }
    }

    (serializer.identifier, hasManifest, manifest, serializer.toBinary(m))
  }

  private def oldDeserialize(p: (ByteString, String)): AnyRef =
    oldDeserialize(p._1, p._2)

  private def oldDeserialize(data: ByteString, className: String): AnyRef =
    if (data.isEmpty && className == "null") null
    else oldDeserialize(data, system.dynamicAccess.getClassFor[AnyRef](className).get)

  private def oldDeserialize[T: ClassTag](data: ByteString, clazz: Class[T]): T = {
    val bytes = data.toByteArray
    serialization.deserialize(bytes, clazz) match {
      case Success(x: T)  ⇒ x
      case Success(other) ⇒ throw new IllegalArgumentException("Can't deserialize to [%s], got [%s]".format(clazz.getName, other))
      case Failure(e) ⇒
        // Fallback to the java serializer, because some interfaces don't implement java.io.Serializable,
        // but the impl instance does. This could be optimized by adding java serializers in reference.conf:
        // com.typesafe.config.Config
        // akka.routing.RouterConfig
        // akka.actor.Scope
        serialization.deserialize(bytes, classOf[java.io.Serializable]) match {
          case Success(x: T) ⇒ x
          case _             ⇒ throw e // the first exception
        }
    }
  }

}
