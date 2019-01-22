/*
 * Copyright (C) 2018-2019 Lightbend Inc. <https://www.lightbend.com>
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClusterMessages.proto

package akka.cluster.typed.internal.protobuf;

public final class ClusterMessages {
  private ClusterMessages() {}
  public static void registerAllExtensions(
      akka.protobuf.ExtensionRegistry registry) {
  }
  public interface ReceptionistEntryOrBuilder
      extends akka.protobuf.MessageOrBuilder {

    // required string actorRef = 1;
    /**
     * <code>required string actorRef = 1;</code>
     */
    boolean hasActorRef();
    /**
     * <code>required string actorRef = 1;</code>
     */
    java.lang.String getActorRef();
    /**
     * <code>required string actorRef = 1;</code>
     */
    akka.protobuf.ByteString
        getActorRefBytes();

    // required uint64 systemUid = 2;
    /**
     * <code>required uint64 systemUid = 2;</code>
     */
    boolean hasSystemUid();
    /**
     * <code>required uint64 systemUid = 2;</code>
     */
    long getSystemUid();
  }
  /**
   * Protobuf type {@code akka.cluster.typed.ReceptionistEntry}
   */
  public static final class ReceptionistEntry extends
      akka.protobuf.GeneratedMessage
      implements ReceptionistEntryOrBuilder {
    // Use ReceptionistEntry.newBuilder() to construct.
    private ReceptionistEntry(akka.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private ReceptionistEntry(boolean noInit) { this.unknownFields = akka.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final ReceptionistEntry defaultInstance;
    public static ReceptionistEntry getDefaultInstance() {
      return defaultInstance;
    }

    public ReceptionistEntry getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final akka.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final akka.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private ReceptionistEntry(
        akka.protobuf.CodedInputStream input,
        akka.protobuf.ExtensionRegistryLite extensionRegistry)
        throws akka.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      akka.protobuf.UnknownFieldSet.Builder unknownFields =
          akka.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              actorRef_ = input.readBytes();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              systemUid_ = input.readUInt64();
              break;
            }
          }
        }
      } catch (akka.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new akka.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final akka.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return akka.cluster.typed.internal.protobuf.ClusterMessages.internal_static_akka_cluster_typed_ReceptionistEntry_descriptor;
    }

    protected akka.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return akka.cluster.typed.internal.protobuf.ClusterMessages.internal_static_akka_cluster_typed_ReceptionistEntry_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry.class, akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry.Builder.class);
    }

    public static akka.protobuf.Parser<ReceptionistEntry> PARSER =
        new akka.protobuf.AbstractParser<ReceptionistEntry>() {
      public ReceptionistEntry parsePartialFrom(
          akka.protobuf.CodedInputStream input,
          akka.protobuf.ExtensionRegistryLite extensionRegistry)
          throws akka.protobuf.InvalidProtocolBufferException {
        return new ReceptionistEntry(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public akka.protobuf.Parser<ReceptionistEntry> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string actorRef = 1;
    public static final int ACTORREF_FIELD_NUMBER = 1;
    private java.lang.Object actorRef_;
    /**
     * <code>required string actorRef = 1;</code>
     */
    public boolean hasActorRef() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string actorRef = 1;</code>
     */
    public java.lang.String getActorRef() {
      java.lang.Object ref = actorRef_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        akka.protobuf.ByteString bs = 
            (akka.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          actorRef_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string actorRef = 1;</code>
     */
    public akka.protobuf.ByteString
        getActorRefBytes() {
      java.lang.Object ref = actorRef_;
      if (ref instanceof java.lang.String) {
        akka.protobuf.ByteString b = 
            akka.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        actorRef_ = b;
        return b;
      } else {
        return (akka.protobuf.ByteString) ref;
      }
    }

    // required uint64 systemUid = 2;
    public static final int SYSTEMUID_FIELD_NUMBER = 2;
    private long systemUid_;
    /**
     * <code>required uint64 systemUid = 2;</code>
     */
    public boolean hasSystemUid() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required uint64 systemUid = 2;</code>
     */
    public long getSystemUid() {
      return systemUid_;
    }

    private void initFields() {
      actorRef_ = "";
      systemUid_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasActorRef()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasSystemUid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(akka.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getActorRefBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeUInt64(2, systemUid_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += akka.protobuf.CodedOutputStream
          .computeBytesSize(1, getActorRefBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += akka.protobuf.CodedOutputStream
          .computeUInt64Size(2, systemUid_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(
        akka.protobuf.ByteString data)
        throws akka.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(
        akka.protobuf.ByteString data,
        akka.protobuf.ExtensionRegistryLite extensionRegistry)
        throws akka.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(byte[] data)
        throws akka.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(
        byte[] data,
        akka.protobuf.ExtensionRegistryLite extensionRegistry)
        throws akka.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(
        java.io.InputStream input,
        akka.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseDelimitedFrom(
        java.io.InputStream input,
        akka.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(
        akka.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parseFrom(
        akka.protobuf.CodedInputStream input,
        akka.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        akka.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code akka.cluster.typed.ReceptionistEntry}
     */
    public static final class Builder extends
        akka.protobuf.GeneratedMessage.Builder<Builder>
       implements akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntryOrBuilder {
      public static final akka.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return akka.cluster.typed.internal.protobuf.ClusterMessages.internal_static_akka_cluster_typed_ReceptionistEntry_descriptor;
      }

      protected akka.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return akka.cluster.typed.internal.protobuf.ClusterMessages.internal_static_akka_cluster_typed_ReceptionistEntry_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry.class, akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry.Builder.class);
      }

      // Construct using akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          akka.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (akka.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        actorRef_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        systemUid_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public akka.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return akka.cluster.typed.internal.protobuf.ClusterMessages.internal_static_akka_cluster_typed_ReceptionistEntry_descriptor;
      }

      public akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry getDefaultInstanceForType() {
        return akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry.getDefaultInstance();
      }

      public akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry build() {
        akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry buildPartial() {
        akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry result = new akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.actorRef_ = actorRef_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.systemUid_ = systemUid_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(akka.protobuf.Message other) {
        if (other instanceof akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry) {
          return mergeFrom((akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry other) {
        if (other == akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry.getDefaultInstance()) return this;
        if (other.hasActorRef()) {
          bitField0_ |= 0x00000001;
          actorRef_ = other.actorRef_;
          onChanged();
        }
        if (other.hasSystemUid()) {
          setSystemUid(other.getSystemUid());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasActorRef()) {
          
          return false;
        }
        if (!hasSystemUid()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          akka.protobuf.CodedInputStream input,
          akka.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (akka.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (akka.cluster.typed.internal.protobuf.ClusterMessages.ReceptionistEntry) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string actorRef = 1;
      private java.lang.Object actorRef_ = "";
      /**
       * <code>required string actorRef = 1;</code>
       */
      public boolean hasActorRef() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string actorRef = 1;</code>
       */
      public java.lang.String getActorRef() {
        java.lang.Object ref = actorRef_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((akka.protobuf.ByteString) ref)
              .toStringUtf8();
          actorRef_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string actorRef = 1;</code>
       */
      public akka.protobuf.ByteString
          getActorRefBytes() {
        java.lang.Object ref = actorRef_;
        if (ref instanceof String) {
          akka.protobuf.ByteString b = 
              akka.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          actorRef_ = b;
          return b;
        } else {
          return (akka.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string actorRef = 1;</code>
       */
      public Builder setActorRef(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        actorRef_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string actorRef = 1;</code>
       */
      public Builder clearActorRef() {
        bitField0_ = (bitField0_ & ~0x00000001);
        actorRef_ = getDefaultInstance().getActorRef();
        onChanged();
        return this;
      }
      /**
       * <code>required string actorRef = 1;</code>
       */
      public Builder setActorRefBytes(
          akka.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        actorRef_ = value;
        onChanged();
        return this;
      }

      // required uint64 systemUid = 2;
      private long systemUid_ ;
      /**
       * <code>required uint64 systemUid = 2;</code>
       */
      public boolean hasSystemUid() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required uint64 systemUid = 2;</code>
       */
      public long getSystemUid() {
        return systemUid_;
      }
      /**
       * <code>required uint64 systemUid = 2;</code>
       */
      public Builder setSystemUid(long value) {
        bitField0_ |= 0x00000002;
        systemUid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 systemUid = 2;</code>
       */
      public Builder clearSystemUid() {
        bitField0_ = (bitField0_ & ~0x00000002);
        systemUid_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:akka.cluster.typed.ReceptionistEntry)
    }

    static {
      defaultInstance = new ReceptionistEntry(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:akka.cluster.typed.ReceptionistEntry)
  }

  private static akka.protobuf.Descriptors.Descriptor
    internal_static_akka_cluster_typed_ReceptionistEntry_descriptor;
  private static
    akka.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_akka_cluster_typed_ReceptionistEntry_fieldAccessorTable;

  public static akka.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static akka.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025ClusterMessages.proto\022\022akka.cluster.ty" +
      "ped\"8\n\021ReceptionistEntry\022\020\n\010actorRef\030\001 \002" +
      "(\t\022\021\n\tsystemUid\030\002 \002(\004B(\n$akka.cluster.ty" +
      "ped.internal.protobufH\001"
    };
    akka.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new akka.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public akka.protobuf.ExtensionRegistry assignDescriptors(
            akka.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_akka_cluster_typed_ReceptionistEntry_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_akka_cluster_typed_ReceptionistEntry_fieldAccessorTable = new
            akka.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_akka_cluster_typed_ReceptionistEntry_descriptor,
              new java.lang.String[] { "ActorRef", "SystemUid", });
          return null;
        }
      };
    akka.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new akka.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}