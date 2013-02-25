package org.jboss.errai.marshalling.client.api;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.enterprise.context.Dependent;
import org.jboss.errai.bus.client.api.base.MessageDeliveryFailure;
import org.jboss.errai.bus.client.api.base.TransportIOException;
import org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.BigDecimalMarshaller;
import org.jboss.errai.marshalling.client.marshallers.BigIntegerMarshaller;
import org.jboss.errai.marshalling.client.marshallers.BooleanMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ByteMarshaller;
import org.jboss.errai.marshalling.client.marshallers.CharacterMarshaller;
import org.jboss.errai.marshalling.client.marshallers.DateMarshaller;
import org.jboss.errai.marshalling.client.marshallers.DoubleMarshaller;
import org.jboss.errai.marshalling.client.marshallers.FloatMarshaller;
import org.jboss.errai.marshalling.client.marshallers.IntegerMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LinkedHashSetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LinkedListMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LinkedMapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ListMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LongMarshaller;
import org.jboss.errai.marshalling.client.marshallers.MapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.marshalling.client.marshallers.PriorityQueueMarshaller;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.jboss.errai.marshalling.client.marshallers.QueueMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SQLDateMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ShortMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SortedMapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SortedSetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringBufferMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringBuilderMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringMarshaller;
import org.jboss.errai.marshalling.client.marshallers.TimeMarshaller;
import org.jboss.errai.marshalling.client.marshallers.TimestampMarshaller;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.uberfire.backend.Root;
import org.uberfire.backend.vfs.FileSystem;
import org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.PathFactory.PathImpl;
import org.uberfire.backend.vfs.impl.BasicAttributesVO;
import org.uberfire.backend.vfs.impl.DirectoryStreamImpl;
import org.uberfire.client.workbench.Position;
import org.uberfire.client.workbench.model.PanelDefinition;
import org.uberfire.client.workbench.model.impl.PanelDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PartDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl;
import org.uberfire.security.auth.AuthenticationException;
import org.uberfire.security.authz.AuthorizationException;
import org.uberfire.shared.mvp.PlaceRequest;
import org.uberfire.shared.mvp.impl.DefaultPlaceRequest;
import org.uberfire.shared.mvp.impl.PathPlaceRequest;
@Dependent public class MarshallerFactoryImpl implements MarshallerFactory {
  private Map<String, Marshaller> marshallers = new HashMap<String, Marshaller>();
  private FloatMarshaller java_lang_Float;
  private LinkedListMarshaller java_util_LinkedList;
  private ListMarshaller java_util_Vector;
  private QueueMarshaller java_util_Queue;
  private SetMarshaller java_util_HashSet;
  private LongMarshaller java_lang_Long;
  private ShortMarshaller java_lang_Short;
  private PriorityQueueMarshaller java_util_PriorityQueue;
  private ListMarshaller java_util_List;
  private SortedSetMarshaller java_util_SortedSet;
  private QualifyingMarshallerWrapper<AbstractMap> java_util_AbstractMap;
  private QueueMarshaller java_util_AbstractQueue;
  private QualifyingMarshallerWrapper<LinkedHashMap> java_util_LinkedHashMap;
  private StringBuilderMarshaller java_lang_StringBuilder;
  private DoubleMarshaller java_lang_Double;
  private QualifyingMarshallerWrapper<Map> java_util_Map;
  private IntegerMarshaller java_lang_Integer;
  private BooleanMarshaller java_lang_Boolean;
  private ObjectMarshaller java_lang_Object;
  private TimestampMarshaller java_sql_Timestamp;
  private SortedSetMarshaller java_util_TreeSet;
  private QualifyingMarshallerWrapper<SortedMap> java_util_SortedMap;
  private BigDecimalMarshaller java_math_BigDecimal;
  private SQLDateMarshaller java_sql_Date;
  private StringMarshaller java_lang_String;
  private QualifyingMarshallerWrapper<HashMap> java_util_HashMap;
  private SetMarshaller java_util_AbstractSet;
  private ListMarshaller java_util_Stack;
  private DateMarshaller java_util_Date;
  private StringBufferMarshaller java_lang_StringBuffer;
  private TimeMarshaller java_sql_Time;
  private BigIntegerMarshaller java_math_BigInteger;
  private LinkedHashSetMarshaller java_util_LinkedHashSet;
  private CharacterMarshaller java_lang_Character;
  private QualifyingMarshallerWrapper<TreeMap> java_util_TreeMap;
  private ListMarshaller java_util_AbstractList;
  private SetMarshaller java_util_Set;
  private ListMarshaller java_util_ArrayList;
  private ByteMarshaller java_lang_Byte;
  private Marshaller<FileSystemImpl> org_uberfire_backend_vfs_FileSystemFactory$FileSystemImpl;
  private QualifyingMarshallerWrapper<StackTraceElement[]> arrayOf_java_lang_StackTraceElement_D1;
  private Marshaller<Throwable> java_lang_Throwable;
  private Marshaller<IllegalArgumentException> java_lang_IllegalArgumentException;
  private Marshaller<UnsupportedOperationException> java_lang_UnsupportedOperationException;
  private Marshaller<PanelDefinitionImpl> org_uberfire_client_workbench_model_impl_PanelDefinitionImpl;
  private Marshaller<AssertionError> java_lang_AssertionError;
  private Marshaller<ArrayStoreException> java_lang_ArrayStoreException;
  private Marshaller<Root> org_uberfire_backend_Root;
  private Marshaller<DataObjectTO> org_jbpm_datamodeler_editor_model_DataObjectTO;
  private Marshaller<PerspectiveDefinitionImpl> org_uberfire_client_workbench_model_impl_PerspectiveDefinitionImpl;
  private Marshaller<DataModelTO> org_jbpm_datamodeler_editor_model_DataModelTO;
  private Marshaller<IOException> java_io_IOException;
  private Marshaller<ClassCastException> java_lang_ClassCastException;
  private Marshaller<StackTraceElement> java_lang_StackTraceElement;
  private Marshaller<IndexOutOfBoundsException> java_lang_IndexOutOfBoundsException;
  private Marshaller<StringIndexOutOfBoundsException> java_lang_StringIndexOutOfBoundsException;
  private Marshaller<AuthorizationException> org_uberfire_security_authz_AuthorizationException;
  private Marshaller<BusReadyEvent> org_jboss_errai_enterprise_client_cdi_events_BusReadyEvent;
  private Marshaller<AuthenticationException> org_uberfire_security_auth_AuthenticationException;
  private Marshaller<ConcurrentModificationException> java_util_ConcurrentModificationException;
  private Marshaller<EmptyStackException> java_util_EmptyStackException;
  private Marshaller<DirectoryStreamImpl> org_uberfire_backend_vfs_impl_DirectoryStreamImpl;
  private Marshaller<RuntimeException> java_lang_RuntimeException;
  private Marshaller<NullPointerException> java_lang_NullPointerException;
  private Marshaller<PathPlaceRequest> org_uberfire_shared_mvp_impl_PathPlaceRequest;
  private Marshaller<NegativeArraySizeException> java_lang_NegativeArraySizeException;
  private Marshaller<TransportIOException> org_jboss_errai_bus_client_api_base_TransportIOException;
  private Marshaller<BasicAttributesVO> org_uberfire_backend_vfs_impl_BasicAttributesVO;
  private Marshaller<Position> org_uberfire_client_workbench_Position;
  private Marshaller<PathImpl> org_uberfire_backend_vfs_PathFactory$PathImpl;
  private Marshaller<ArithmeticException> java_lang_ArithmeticException;
  private Marshaller<MessageDeliveryFailure> org_jboss_errai_bus_client_api_base_MessageDeliveryFailure;
  private Marshaller<ObjectPropertyTO> org_jbpm_datamodeler_editor_model_ObjectPropertyTO;
  private Marshaller<DefaultPlaceRequest> org_uberfire_shared_mvp_impl_DefaultPlaceRequest;
  private Marshaller<PartDefinitionImpl> org_uberfire_client_workbench_model_impl_PartDefinitionImpl;
  private QualifyingMarshallerWrapper<Object[]> arrayOf_java_lang_Object_D1;
  private QualifyingMarshallerWrapper<String[]> arrayOf_java_lang_String_D1;
  private QualifyingMarshallerWrapper<int[]> arrayOf_int_D1;
  private QualifyingMarshallerWrapper<long[]> arrayOf_long_D1;
  private QualifyingMarshallerWrapper<double[]> arrayOf_double_D1;
  private QualifyingMarshallerWrapper<float[]> arrayOf_float_D1;
  private QualifyingMarshallerWrapper<short[]> arrayOf_short_D1;
  private QualifyingMarshallerWrapper<boolean[]> arrayOf_boolean_D1;
  private QualifyingMarshallerWrapper<byte[]> arrayOf_byte_D1;
  private QualifyingMarshallerWrapper<char[]> arrayOf_char_D1;
  private QualifyingMarshallerWrapper<Integer[]> arrayOf_java_lang_Integer_D1;
  private QualifyingMarshallerWrapper<Long[]> arrayOf_java_lang_Long_D1;
  private QualifyingMarshallerWrapper<Double[]> arrayOf_java_lang_Double_D1;
  private QualifyingMarshallerWrapper<Float[]> arrayOf_java_lang_Float_D1;
  private QualifyingMarshallerWrapper<Short[]> arrayOf_java_lang_Short_D1;
  private QualifyingMarshallerWrapper<Boolean[]> arrayOf_java_lang_Boolean_D1;
  private QualifyingMarshallerWrapper<Byte[]> arrayOf_java_lang_Byte_D1;
  private QualifyingMarshallerWrapper<Character[]> arrayOf_java_lang_Character_D1;
  public MarshallerFactoryImpl() {
    java_lang_Float = new FloatMarshaller();
    marshallers.put("java.lang.Float", java_lang_Float);
    java_util_LinkedList = new LinkedListMarshaller();
    marshallers.put("java.util.LinkedList", java_util_LinkedList);
    java_util_Vector = new ListMarshaller();
    marshallers.put("java.util.Vector", java_util_Vector);
    java_util_Queue = new QueueMarshaller();
    marshallers.put("java.util.Queue", java_util_Queue);
    marshallers.put("java.util.AbstractQueue", java_util_Queue);
    java_util_HashSet = new SetMarshaller();
    marshallers.put("java.util.HashSet", java_util_HashSet);
    java_lang_Long = new LongMarshaller();
    marshallers.put("java.lang.Long", java_lang_Long);
    java_lang_Short = new ShortMarshaller();
    marshallers.put("java.lang.Short", java_lang_Short);
    java_util_PriorityQueue = new PriorityQueueMarshaller();
    marshallers.put("java.util.PriorityQueue", java_util_PriorityQueue);
    java_util_List = new ListMarshaller();
    marshallers.put("java.util.List", java_util_List);
    marshallers.put("java.util.Collections$SynchronizedRandomAccessList", java_util_List);
    marshallers.put("java.util.Collections$UnmodifiableRandomAccessList", java_util_List);
    marshallers.put("java.util.Stack", java_util_List);
    marshallers.put("java.util.Vector", java_util_List);
    marshallers.put("java.util.ArrayList", java_util_List);
    marshallers.put("java.util.Collections$SingletonList", java_util_List);
    marshallers.put("java.util.Collections$SynchronizedList", java_util_List);
    marshallers.put("java.util.Collections$UnmodifiableList", java_util_List);
    marshallers.put("java.util.Collections$EmptyList", java_util_List);
    marshallers.put("java.util.Arrays$ArrayList", java_util_List);
    marshallers.put("java.util.AbstractList", java_util_List);
    java_util_SortedSet = new SortedSetMarshaller();
    marshallers.put("java.util.SortedSet", java_util_SortedSet);
    marshallers.put("java.util.Collections$UnmodifiableSortedSet", java_util_SortedSet);
    marshallers.put("java.util.TreeSet", java_util_SortedSet);
    marshallers.put("java.util.Collections$SynchronizedSortedSet", java_util_SortedSet);
    java_util_AbstractMap = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.AbstractMap", java_util_AbstractMap);
    java_util_AbstractQueue = new QueueMarshaller();
    marshallers.put("java.util.AbstractQueue", java_util_AbstractQueue);
    java_util_LinkedHashMap = new QualifyingMarshallerWrapper(new LinkedMapMarshaller());
    marshallers.put("java.util.LinkedHashMap", java_util_LinkedHashMap);
    java_lang_StringBuilder = new StringBuilderMarshaller();
    marshallers.put("java.lang.StringBuilder", java_lang_StringBuilder);
    java_lang_Double = new DoubleMarshaller();
    marshallers.put("java.lang.Double", java_lang_Double);
    java_util_Map = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.Map", java_util_Map);
    marshallers.put("java.util.Collections$SingletonMap", java_util_Map);
    marshallers.put("java.util.AbstractMap", java_util_Map);
    marshallers.put("java.util.Collections$SynchronizedMap", java_util_Map);
    marshallers.put("java.util.HashMap", java_util_Map);
    marshallers.put("java.util.Collections$UnmodifiableMap", java_util_Map);
    marshallers.put("java.util.Collections$EmptyMap", java_util_Map);
    java_lang_Integer = new IntegerMarshaller();
    marshallers.put("java.lang.Integer", java_lang_Integer);
    java_lang_Boolean = new BooleanMarshaller();
    marshallers.put("java.lang.Boolean", java_lang_Boolean);
    java_lang_Object = new ObjectMarshaller();
    marshallers.put("java.lang.Object", java_lang_Object);
    java_sql_Timestamp = new TimestampMarshaller();
    marshallers.put("java.sql.Timestamp", java_sql_Timestamp);
    java_util_TreeSet = new SortedSetMarshaller();
    marshallers.put("java.util.TreeSet", java_util_TreeSet);
    java_util_SortedMap = new QualifyingMarshallerWrapper(new SortedMapMarshaller());
    marshallers.put("java.util.SortedMap", java_util_SortedMap);
    marshallers.put("java.util.Collections$SynchronizedSortedMap", java_util_SortedMap);
    marshallers.put("java.util.Collections$UnmodifiableSortedMap", java_util_SortedMap);
    marshallers.put("java.util.TreeMap", java_util_SortedMap);
    java_math_BigDecimal = new BigDecimalMarshaller();
    marshallers.put("java.math.BigDecimal", java_math_BigDecimal);
    java_sql_Date = new SQLDateMarshaller();
    marshallers.put("java.sql.Date", java_sql_Date);
    java_lang_String = new StringMarshaller();
    marshallers.put("java.lang.String", java_lang_String);
    java_util_HashMap = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.HashMap", java_util_HashMap);
    java_util_AbstractSet = new SetMarshaller();
    marshallers.put("java.util.AbstractSet", java_util_AbstractSet);
    java_util_Stack = new ListMarshaller();
    marshallers.put("java.util.Stack", java_util_Stack);
    java_util_Date = new DateMarshaller();
    marshallers.put("java.util.Date", java_util_Date);
    java_lang_StringBuffer = new StringBufferMarshaller();
    marshallers.put("java.lang.StringBuffer", java_lang_StringBuffer);
    java_sql_Time = new TimeMarshaller();
    marshallers.put("java.sql.Time", java_sql_Time);
    java_math_BigInteger = new BigIntegerMarshaller();
    marshallers.put("java.math.BigInteger", java_math_BigInteger);
    java_util_LinkedHashSet = new LinkedHashSetMarshaller();
    marshallers.put("java.util.LinkedHashSet", java_util_LinkedHashSet);
    java_lang_Character = new CharacterMarshaller();
    marshallers.put("java.lang.Character", java_lang_Character);
    java_util_TreeMap = new QualifyingMarshallerWrapper(new SortedMapMarshaller());
    marshallers.put("java.util.TreeMap", java_util_TreeMap);
    java_util_AbstractList = new ListMarshaller();
    marshallers.put("java.util.AbstractList", java_util_AbstractList);
    java_util_Set = new SetMarshaller();
    marshallers.put("java.util.Set", java_util_Set);
    marshallers.put("java.util.Collections$SynchronizedSet", java_util_Set);
    marshallers.put("java.util.Collections$UnmodifiableSet", java_util_Set);
    marshallers.put("java.util.Collections$EmptySet", java_util_Set);
    marshallers.put("java.util.Collections$SingletonSet", java_util_Set);
    marshallers.put("java.util.AbstractSet", java_util_Set);
    marshallers.put("java.util.HashSet", java_util_Set);
    java_util_ArrayList = new ListMarshaller();
    marshallers.put("java.util.ArrayList", java_util_ArrayList);
    java_lang_Byte = new ByteMarshaller();
    marshallers.put("java.lang.Byte", java_lang_Byte);
    org_uberfire_backend_vfs_FileSystemFactory$FileSystemImpl = new Marshaller<FileSystemImpl>() {
      private FileSystemImpl[] EMPTY_ARRAY = new FileSystemImpl[0];
      public FileSystemImpl[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return FileSystemImpl.class;
      }
      public FileSystemImpl demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(FileSystemImpl.class, objId);
          }
          FileSystemImpl entity = new FileSystemImpl();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("rootDirectories")) && (!obj.get("rootDirectories").isNull())) {
            a1.setAssumedElementType("org.uberfire.backend.vfs.Path");
            _$1821390935_rootDirectories(entity, java_util_List.demarshall(obj.get("rootDirectories"), a1));
            a1.setAssumedElementType(null);
          }
          if ((obj.containsKey("supportedViews")) && (!obj.get("supportedViews").isNull())) {
            a1.setAssumedElementType("java.lang.String");
            _$1821390935_supportedViews(entity, java_util_Set.demarshall(obj.get("supportedViews"), a1));
            a1.setAssumedElementType(null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.backend.vfs.FileSystemFactory$FileSystemImpl", t);
        }
      }
      public String marshall(FileSystemImpl a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.FileSystemFactory$FileSystemImpl\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(384).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.FileSystemFactory$FileSystemImpl\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"rootDirectories\" : ").append(java_util_List.marshall(a0.getRootDirectories(), a1)).append(",").append("\"supportedViews\" : ").append(java_util_Set.marshall(_$1821390935_supportedViews(a0), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.backend.vfs.FileSystemFactory$FileSystemImpl", org_uberfire_backend_vfs_FileSystemFactory$FileSystemImpl);
    marshallers.put("org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl", org_uberfire_backend_vfs_FileSystemFactory$FileSystemImpl);
    arrayOf_java_lang_StackTraceElement_D1 = new QualifyingMarshallerWrapper(new Marshaller<StackTraceElement[]>() {
      public java.lang.StackTraceElement[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private StackTraceElement[] _demarshall1(EJArray a0, MarshallingSession a1) {
        StackTraceElement[] newArray = new StackTraceElement[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_StackTraceElement.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(StackTraceElement[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return StackTraceElement.class;
      }
      public StackTraceElement[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(StackTraceElement[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.StackTraceElement;", arrayOf_java_lang_StackTraceElement_D1);
    java_lang_Throwable = new Marshaller<Throwable>() {
      private Throwable[] EMPTY_ARRAY = new Throwable[0];
      public Throwable[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return Throwable.class;
      }
      public Throwable demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(Throwable.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          Throwable entity = new Throwable(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.Throwable", t);
        }
      }
      public String marshall(Throwable a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.Throwable\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3072).append("{\"^EncodedType\":\"java.lang.Throwable\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.Throwable", java_lang_Throwable);
    java_lang_IllegalArgumentException = new Marshaller<IllegalArgumentException>() {
      private IllegalArgumentException[] EMPTY_ARRAY = new IllegalArgumentException[0];
      public IllegalArgumentException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return IllegalArgumentException.class;
      }
      public IllegalArgumentException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(IllegalArgumentException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          IllegalArgumentException entity = new IllegalArgumentException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.IllegalArgumentException", t);
        }
      }
      public String marshall(IllegalArgumentException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.IllegalArgumentException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.IllegalArgumentException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.IllegalArgumentException", java_lang_IllegalArgumentException);
    java_lang_UnsupportedOperationException = new Marshaller<UnsupportedOperationException>() {
      private UnsupportedOperationException[] EMPTY_ARRAY = new UnsupportedOperationException[0];
      public UnsupportedOperationException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return UnsupportedOperationException.class;
      }
      public UnsupportedOperationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(UnsupportedOperationException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          UnsupportedOperationException entity = new UnsupportedOperationException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.UnsupportedOperationException", t);
        }
      }
      public String marshall(UnsupportedOperationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.UnsupportedOperationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.UnsupportedOperationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.UnsupportedOperationException", java_lang_UnsupportedOperationException);
    org_uberfire_client_workbench_model_impl_PanelDefinitionImpl = new Marshaller<PanelDefinitionImpl>() {
      private PanelDefinitionImpl[] EMPTY_ARRAY = new PanelDefinitionImpl[0];
      public PanelDefinitionImpl[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return PanelDefinitionImpl.class;
      }
      public PanelDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(PanelDefinitionImpl.class, objId);
          }
          PanelDefinitionImpl entity = new PanelDefinitionImpl();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("height")) && (!obj.get("height").isNull())) {
            entity.setHeight(java_lang_Integer.demarshall(obj.get("height"), a1));
          }
          if ((obj.containsKey("width")) && (!obj.get("width").isNull())) {
            entity.setWidth(java_lang_Integer.demarshall(obj.get("width"), a1));
          }
          if ((obj.containsKey("minHeight")) && (!obj.get("minHeight").isNull())) {
            entity.setMinHeight(java_lang_Integer.demarshall(obj.get("minHeight"), a1));
          }
          if ((obj.containsKey("minWidth")) && (!obj.get("minWidth").isNull())) {
            entity.setMinWidth(java_lang_Integer.demarshall(obj.get("minWidth"), a1));
          }
          if ((obj.containsKey("isRoot")) && (!obj.get("isRoot").isNull())) {
            _1257775948_isRoot(entity, java_lang_Boolean.demarshall(obj.get("isRoot"), a1));
          }
          if ((obj.containsKey("parts")) && (!obj.get("parts").isNull())) {
            a1.setAssumedElementType("org.uberfire.client.workbench.model.PartDefinition");
            _1257775948_parts(entity, java_util_Set.demarshall(obj.get("parts"), a1));
            a1.setAssumedElementType(null);
          }
          if ((obj.containsKey("children")) && (!obj.get("children").isNull())) {
            a1.setAssumedElementType("org.uberfire.client.workbench.model.PanelDefinition");
            _1257775948_children(entity, java_util_List.demarshall(obj.get("children"), a1));
            a1.setAssumedElementType(null);
          }
          if ((obj.containsKey("position")) && (!obj.get("position").isNull())) {
            entity.setPosition(obj.get("position").isObject() != null ? Enum.valueOf(Position.class, obj.get("position").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("position").isString() != null ? Enum.valueOf(Position.class, obj.get("position").isString().stringValue()) : null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.client.workbench.model.impl.PanelDefinitionImpl", t);
        }
      }
      public String marshall(PanelDefinitionImpl a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.client.workbench.model.impl.PanelDefinitionImpl\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(1152).append("{\"^EncodedType\":\"org.uberfire.client.workbench.model.impl.PanelDefinitionImpl\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"height\" : ").append(java_lang_Integer.marshall(a0.getHeight(), a1)).append(",").append("\"width\" : ").append(java_lang_Integer.marshall(a0.getWidth(), a1)).append(",").append("\"minHeight\" : ").append(java_lang_Integer.marshall(a0.getMinHeight(), a1)).append(",").append("\"minWidth\" : ").append(java_lang_Integer.marshall(a0.getMinWidth(), a1)).append(",").append("\"isRoot\" : ").append(java_lang_Boolean.marshall(_1257775948_isRoot(a0), a1)).append(",").append("\"parts\" : ").append(java_util_Set.marshall(a0.getParts(), a1)).append(",").append("\"children\" : ").append(java_util_List.marshall(a0.getChildren(), a1)).append(",").append("\"position\" : ").append(a0.getPosition() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.client.workbench.Position\",\"^EnumStringValue\":\"").append(a0.getPosition().name()).append("\"}") : "null").append("}").toString();
      }
    };
    marshallers.put("org.uberfire.client.workbench.model.impl.PanelDefinitionImpl", org_uberfire_client_workbench_model_impl_PanelDefinitionImpl);
    java_lang_AssertionError = new Marshaller<AssertionError>() {
      private AssertionError[] EMPTY_ARRAY = new AssertionError[0];
      public AssertionError[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return AssertionError.class;
      }
      public AssertionError demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(AssertionError.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          AssertionError entity = new AssertionError(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.AssertionError", t);
        }
      }
      public String marshall(AssertionError a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.AssertionError\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.AssertionError\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.AssertionError", java_lang_AssertionError);
    java_lang_ArrayStoreException = new Marshaller<ArrayStoreException>() {
      private ArrayStoreException[] EMPTY_ARRAY = new ArrayStoreException[0];
      public ArrayStoreException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ArrayStoreException.class;
      }
      public ArrayStoreException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ArrayStoreException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ArrayStoreException entity = new ArrayStoreException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ArrayStoreException", t);
        }
      }
      public String marshall(ArrayStoreException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ArrayStoreException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ArrayStoreException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.ArrayStoreException", java_lang_ArrayStoreException);
    org_uberfire_backend_Root = new Marshaller<Root>() {
      private Root[] EMPTY_ARRAY = new Root[0];
      public Root[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return Root.class;
      }
      public Root demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(Root.class, objId);
          }
          Root entity = new Root();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
            _$2135925616_path(entity, (Path) java_lang_Object.demarshall(Path.class, obj.get("path"), a1));
          }
          if ((obj.containsKey("placeRequest")) && (!obj.get("placeRequest").isNull())) {
            _$2135925616_placeRequest(entity, (PlaceRequest) java_lang_Object.demarshall(PlaceRequest.class, obj.get("placeRequest"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.backend.Root", t);
        }
      }
      public String marshall(Root a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.backend.Root\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(384).append("{\"^EncodedType\":\"org.uberfire.backend.Root\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"path\" : ").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"placeRequest\" : ").append(java_lang_Object.marshall(a0.getPlaceRequest(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.backend.Root", org_uberfire_backend_Root);
    org_jbpm_datamodeler_editor_model_DataObjectTO = new Marshaller<DataObjectTO>() {
      private DataObjectTO[] EMPTY_ARRAY = new DataObjectTO[0];
      public DataObjectTO[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return DataObjectTO.class;
      }
      public DataObjectTO demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(DataObjectTO.class, objId);
          }
          DataObjectTO entity = new DataObjectTO();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
            entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
          }
          if ((obj.containsKey("properties")) && (!obj.get("properties").isNull())) {
            a1.setAssumedElementType("org.jbpm.datamodeler.editor.model.ObjectPropertyTO");
            entity.setProperties(java_util_List.demarshall(obj.get("properties"), a1));
            a1.setAssumedElementType(null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jbpm.datamodeler.editor.model.DataObjectTO", t);
        }
      }
      public String marshall(DataObjectTO a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jbpm.datamodeler.editor.model.DataObjectTO\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(384).append("{\"^EncodedType\":\"org.jbpm.datamodeler.editor.model.DataObjectTO\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"name\" : ").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"properties\" : ").append(java_util_List.marshall(a0.getProperties(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.jbpm.datamodeler.editor.model.DataObjectTO", org_jbpm_datamodeler_editor_model_DataObjectTO);
    org_uberfire_client_workbench_model_impl_PerspectiveDefinitionImpl = new Marshaller<PerspectiveDefinitionImpl>() {
      private PerspectiveDefinitionImpl[] EMPTY_ARRAY = new PerspectiveDefinitionImpl[0];
      public PerspectiveDefinitionImpl[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return PerspectiveDefinitionImpl.class;
      }
      public PerspectiveDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(PerspectiveDefinitionImpl.class, objId);
          }
          PerspectiveDefinitionImpl entity = new PerspectiveDefinitionImpl();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
            entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
          }
          if ((obj.containsKey("isTransient")) && (!obj.get("isTransient").isNull())) {
            _741338564_isTransient(entity, java_lang_Boolean.demarshall(obj.get("isTransient"), a1));
          }
          if ((obj.containsKey("root")) && (!obj.get("root").isNull())) {
            _741338564_root(entity, (PanelDefinition) java_lang_Object.demarshall(PanelDefinition.class, obj.get("root"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl", t);
        }
      }
      public String marshall(PerspectiveDefinitionImpl a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(512).append("{\"^EncodedType\":\"org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"name\" : ").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"isTransient\" : ").append(java_lang_Boolean.marshall(_741338564_isTransient(a0), a1)).append(",").append("\"root\" : ").append(java_lang_Object.marshall(a0.getRoot(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl", org_uberfire_client_workbench_model_impl_PerspectiveDefinitionImpl);
    org_jbpm_datamodeler_editor_model_DataModelTO = new Marshaller<DataModelTO>() {
      private DataModelTO[] EMPTY_ARRAY = new DataModelTO[0];
      public DataModelTO[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return DataModelTO.class;
      }
      public DataModelTO demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(DataModelTO.class, objId);
          }
          DataModelTO entity = new DataModelTO();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
            entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
          }
          if ((obj.containsKey("dataObjects")) && (!obj.get("dataObjects").isNull())) {
            a1.setAssumedElementType("org.jbpm.datamodeler.editor.model.DataObjectTO");
            entity.setDataObjects(java_util_List.demarshall(obj.get("dataObjects"), a1));
            a1.setAssumedElementType(null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jbpm.datamodeler.editor.model.DataModelTO", t);
        }
      }
      public String marshall(DataModelTO a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jbpm.datamodeler.editor.model.DataModelTO\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(384).append("{\"^EncodedType\":\"org.jbpm.datamodeler.editor.model.DataModelTO\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"name\" : ").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"dataObjects\" : ").append(java_util_List.marshall(a0.getDataObjects(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.jbpm.datamodeler.editor.model.DataModelTO", org_jbpm_datamodeler_editor_model_DataModelTO);
    java_io_IOException = new Marshaller<IOException>() {
      private IOException[] EMPTY_ARRAY = new IOException[0];
      public IOException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return IOException.class;
      }
      public IOException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(IOException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          IOException entity = new IOException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.io.IOException", t);
        }
      }
      public String marshall(IOException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.io.IOException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.io.IOException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.io.IOException", java_io_IOException);
    java_lang_ClassCastException = new Marshaller<ClassCastException>() {
      private ClassCastException[] EMPTY_ARRAY = new ClassCastException[0];
      public ClassCastException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ClassCastException.class;
      }
      public ClassCastException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ClassCastException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ClassCastException entity = new ClassCastException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ClassCastException", t);
        }
      }
      public String marshall(ClassCastException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ClassCastException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ClassCastException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.ClassCastException", java_lang_ClassCastException);
    java_lang_StackTraceElement = new Marshaller<StackTraceElement>() {
      private StackTraceElement[] EMPTY_ARRAY = new StackTraceElement[0];
      public StackTraceElement[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return StackTraceElement.class;
      }
      public StackTraceElement demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(StackTraceElement.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("declaringClass"), a1);
          final String c1 = java_lang_String.demarshall(obj.get("methodName"), a1);
          final String c2 = java_lang_String.demarshall(obj.get("fileName"), a1);
          final Integer c3 = java_lang_Integer.demarshall(obj.get("lineNumber"), a1);
          StackTraceElement entity = new StackTraceElement(c0, c1, c2, c3);
          a1.recordObject(objId, entity);
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.StackTraceElement", t);
        }
      }
      public String marshall(StackTraceElement a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.StackTraceElement\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(640).append("{\"^EncodedType\":\"java.lang.StackTraceElement\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"fileName\" : ").append(java_lang_String.marshall(a0.getFileName(), a1)).append(",").append("\"methodName\" : ").append(java_lang_String.marshall(a0.getMethodName(), a1)).append(",").append("\"lineNumber\" : ").append(java_lang_Integer.marshall(a0.getLineNumber(), a1)).append(",").append("\"declaringClass\" : ").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.StackTraceElement", java_lang_StackTraceElement);
    java_lang_IndexOutOfBoundsException = new Marshaller<IndexOutOfBoundsException>() {
      private IndexOutOfBoundsException[] EMPTY_ARRAY = new IndexOutOfBoundsException[0];
      public IndexOutOfBoundsException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return IndexOutOfBoundsException.class;
      }
      public IndexOutOfBoundsException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(IndexOutOfBoundsException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          IndexOutOfBoundsException entity = new IndexOutOfBoundsException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.IndexOutOfBoundsException", t);
        }
      }
      public String marshall(IndexOutOfBoundsException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.IndexOutOfBoundsException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.IndexOutOfBoundsException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.IndexOutOfBoundsException", java_lang_IndexOutOfBoundsException);
    java_lang_StringIndexOutOfBoundsException = new Marshaller<StringIndexOutOfBoundsException>() {
      private StringIndexOutOfBoundsException[] EMPTY_ARRAY = new StringIndexOutOfBoundsException[0];
      public StringIndexOutOfBoundsException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return StringIndexOutOfBoundsException.class;
      }
      public StringIndexOutOfBoundsException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(StringIndexOutOfBoundsException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          StringIndexOutOfBoundsException entity = new StringIndexOutOfBoundsException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.StringIndexOutOfBoundsException", t);
        }
      }
      public String marshall(StringIndexOutOfBoundsException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.StringIndexOutOfBoundsException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.StringIndexOutOfBoundsException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.StringIndexOutOfBoundsException", java_lang_StringIndexOutOfBoundsException);
    org_uberfire_security_authz_AuthorizationException = new Marshaller<AuthorizationException>() {
      private AuthorizationException[] EMPTY_ARRAY = new AuthorizationException[0];
      public AuthorizationException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return AuthorizationException.class;
      }
      public AuthorizationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(AuthorizationException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          AuthorizationException entity = new AuthorizationException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.security.authz.AuthorizationException", t);
        }
      }
      public String marshall(AuthorizationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.security.authz.AuthorizationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"org.uberfire.security.authz.AuthorizationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.security.authz.AuthorizationException", org_uberfire_security_authz_AuthorizationException);
    org_jboss_errai_enterprise_client_cdi_events_BusReadyEvent = new Marshaller<BusReadyEvent>() {
      private BusReadyEvent[] EMPTY_ARRAY = new BusReadyEvent[0];
      public BusReadyEvent[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return BusReadyEvent.class;
      }
      public BusReadyEvent demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(BusReadyEvent.class, objId);
          }
          BusReadyEvent entity = new BusReadyEvent();
          a1.recordObject(objId, entity);
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent", t);
        }
      }
      public String marshall(BusReadyEvent a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent\",\"^ObjectID\":\"").append(objId).append("\"").append(",\"^InstantiateOnly\":true").append("}").toString();
      }
    };
    marshallers.put("org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent", org_jboss_errai_enterprise_client_cdi_events_BusReadyEvent);
    org_uberfire_security_auth_AuthenticationException = new Marshaller<AuthenticationException>() {
      private AuthenticationException[] EMPTY_ARRAY = new AuthenticationException[0];
      public AuthenticationException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return AuthenticationException.class;
      }
      public AuthenticationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(AuthenticationException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          AuthenticationException entity = new AuthenticationException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.security.auth.AuthenticationException", t);
        }
      }
      public String marshall(AuthenticationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.security.auth.AuthenticationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"org.uberfire.security.auth.AuthenticationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.security.auth.AuthenticationException", org_uberfire_security_auth_AuthenticationException);
    java_util_ConcurrentModificationException = new Marshaller<ConcurrentModificationException>() {
      private ConcurrentModificationException[] EMPTY_ARRAY = new ConcurrentModificationException[0];
      public ConcurrentModificationException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ConcurrentModificationException.class;
      }
      public ConcurrentModificationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ConcurrentModificationException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ConcurrentModificationException entity = new ConcurrentModificationException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.util.ConcurrentModificationException", t);
        }
      }
      public String marshall(ConcurrentModificationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.util.ConcurrentModificationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.util.ConcurrentModificationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.util.ConcurrentModificationException", java_util_ConcurrentModificationException);
    java_util_EmptyStackException = new Marshaller<EmptyStackException>() {
      private EmptyStackException[] EMPTY_ARRAY = new EmptyStackException[0];
      public EmptyStackException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return EmptyStackException.class;
      }
      public EmptyStackException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(EmptyStackException.class, objId);
          }
          EmptyStackException entity = new EmptyStackException();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.util.EmptyStackException", t);
        }
      }
      public String marshall(EmptyStackException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.util.EmptyStackException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.util.EmptyStackException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.util.EmptyStackException", java_util_EmptyStackException);
    org_uberfire_backend_vfs_impl_DirectoryStreamImpl = new Marshaller<DirectoryStreamImpl>() {
      private DirectoryStreamImpl[] EMPTY_ARRAY = new DirectoryStreamImpl[0];
      public DirectoryStreamImpl[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return DirectoryStreamImpl.class;
      }
      public DirectoryStreamImpl demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(DirectoryStreamImpl.class, objId);
          }
          DirectoryStreamImpl entity = new DirectoryStreamImpl();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("content")) && (!obj.get("content").isNull())) {
            a1.setAssumedElementType("org.uberfire.backend.vfs.Path");
            _1281341560_content(entity, java_util_List.demarshall(obj.get("content"), a1));
            a1.setAssumedElementType(null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.backend.vfs.impl.DirectoryStreamImpl", t);
        }
      }
      public String marshall(DirectoryStreamImpl a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.DirectoryStreamImpl\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(256).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.DirectoryStreamImpl\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"content\" : ").append(java_util_List.marshall(_1281341560_content(a0), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.backend.vfs.impl.DirectoryStreamImpl", org_uberfire_backend_vfs_impl_DirectoryStreamImpl);
    java_lang_RuntimeException = new Marshaller<RuntimeException>() {
      private RuntimeException[] EMPTY_ARRAY = new RuntimeException[0];
      public RuntimeException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return RuntimeException.class;
      }
      public RuntimeException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(RuntimeException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          RuntimeException entity = new RuntimeException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.RuntimeException", t);
        }
      }
      public String marshall(RuntimeException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.RuntimeException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.RuntimeException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.RuntimeException", java_lang_RuntimeException);
    java_lang_NullPointerException = new Marshaller<NullPointerException>() {
      private NullPointerException[] EMPTY_ARRAY = new NullPointerException[0];
      public NullPointerException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return NullPointerException.class;
      }
      public NullPointerException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(NullPointerException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          NullPointerException entity = new NullPointerException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.NullPointerException", t);
        }
      }
      public String marshall(NullPointerException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.NullPointerException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.NullPointerException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.NullPointerException", java_lang_NullPointerException);
    org_uberfire_shared_mvp_impl_PathPlaceRequest = new Marshaller<PathPlaceRequest>() {
      private PathPlaceRequest[] EMPTY_ARRAY = new PathPlaceRequest[0];
      public PathPlaceRequest[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return PathPlaceRequest.class;
      }
      public PathPlaceRequest demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(PathPlaceRequest.class, objId);
          }
          PathPlaceRequest entity = new PathPlaceRequest();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
            _$1883331105_path(entity, (Path) java_lang_Object.demarshall(Path.class, obj.get("path"), a1));
          }
          if ((obj.containsKey("identifier")) && (!obj.get("identifier").isNull())) {
            _$753915497_identifier(entity, java_lang_String.demarshall(obj.get("identifier"), a1));
          }
          if ((obj.containsKey("parameters")) && (!obj.get("parameters").isNull())) {
            a1.setAssumedMapKeyType("java.lang.String");
            a1.setAssumedMapValueType("java.lang.String");
            _$753915497_parameters(entity, (Map) java_util_Map.demarshall(obj.get("parameters"), a1));
            a1.setAssumedMapKeyType(null);
            a1.setAssumedMapValueType(null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.shared.mvp.impl.PathPlaceRequest", t);
        }
      }
      public String marshall(PathPlaceRequest a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.shared.mvp.impl.PathPlaceRequest\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(512).append("{\"^EncodedType\":\"org.uberfire.shared.mvp.impl.PathPlaceRequest\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"path\" : ").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"identifier\" : ").append(java_lang_String.marshall(a0.getIdentifier(), a1)).append(",").append("\"parameters\" : ").append(java_util_Map.marshall(a0.getParameters(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.shared.mvp.impl.PathPlaceRequest", org_uberfire_shared_mvp_impl_PathPlaceRequest);
    java_lang_NegativeArraySizeException = new Marshaller<NegativeArraySizeException>() {
      private NegativeArraySizeException[] EMPTY_ARRAY = new NegativeArraySizeException[0];
      public NegativeArraySizeException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return NegativeArraySizeException.class;
      }
      public NegativeArraySizeException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(NegativeArraySizeException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          NegativeArraySizeException entity = new NegativeArraySizeException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.NegativeArraySizeException", t);
        }
      }
      public String marshall(NegativeArraySizeException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.NegativeArraySizeException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.NegativeArraySizeException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.NegativeArraySizeException", java_lang_NegativeArraySizeException);
    org_jboss_errai_bus_client_api_base_TransportIOException = new Marshaller<TransportIOException>() {
      private TransportIOException[] EMPTY_ARRAY = new TransportIOException[0];
      public TransportIOException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return TransportIOException.class;
      }
      public TransportIOException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(TransportIOException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          final Integer c1 = java_lang_Integer.demarshall(obj.get("errorCode"), a1);
          final String c2 = java_lang_String.demarshall(obj.get("errorMessage"), a1);
          TransportIOException entity = new TransportIOException(c0, c1, c2);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jboss.errai.bus.client.api.base.TransportIOException", t);
        }
      }
      public String marshall(TransportIOException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.TransportIOException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(4224).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.TransportIOException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"errorCode\" : ").append(java_lang_Integer.marshall(a0.errorCode(), a1)).append(",").append("\"errorMessage\" : ").append(java_lang_String.marshall(a0.getErrorMessage(), a1)).append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.jboss.errai.bus.client.api.base.TransportIOException", org_jboss_errai_bus_client_api_base_TransportIOException);
    org_uberfire_backend_vfs_impl_BasicAttributesVO = new Marshaller<BasicAttributesVO>() {
      private BasicAttributesVO[] EMPTY_ARRAY = new BasicAttributesVO[0];
      public BasicAttributesVO[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return BasicAttributesVO.class;
      }
      public BasicAttributesVO demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(BasicAttributesVO.class, objId);
          }
          BasicAttributesVO entity = new BasicAttributesVO();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("isRegularFile")) && (!obj.get("isRegularFile").isNull())) {
            _$178984759_isRegularFile(entity, java_lang_Boolean.demarshall(obj.get("isRegularFile"), a1));
          }
          if ((obj.containsKey("isDirectory")) && (!obj.get("isDirectory").isNull())) {
            _$178984759_isDirectory(entity, java_lang_Boolean.demarshall(obj.get("isDirectory"), a1));
          }
          if ((obj.containsKey("isSymbolicLink")) && (!obj.get("isSymbolicLink").isNull())) {
            _$178984759_isSymbolicLink(entity, java_lang_Boolean.demarshall(obj.get("isSymbolicLink"), a1));
          }
          if ((obj.containsKey("isOther")) && (!obj.get("isOther").isNull())) {
            _$178984759_isOther(entity, java_lang_Boolean.demarshall(obj.get("isOther"), a1));
          }
          if ((obj.containsKey("size")) && (!obj.get("size").isNull())) {
            _$178984759_size(entity, java_lang_Long.demarshall(obj.get("size"), a1));
          }
          if ((obj.containsKey("fileKey")) && (!obj.get("fileKey").isNull())) {
            _$178984759_fileKey(entity, java_lang_Object.demarshall(Object.class, obj.get("fileKey"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.backend.vfs.impl.BasicAttributesVO", t);
        }
      }
      public String marshall(BasicAttributesVO a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.BasicAttributesVO\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(896).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.BasicAttributesVO\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"isRegularFile\" : ").append(java_lang_Boolean.marshall(_$178984759_isRegularFile(a0), a1)).append(",").append("\"isDirectory\" : ").append(java_lang_Boolean.marshall(_$178984759_isDirectory(a0), a1)).append(",").append("\"isSymbolicLink\" : ").append(java_lang_Boolean.marshall(_$178984759_isSymbolicLink(a0), a1)).append(",").append("\"isOther\" : ").append(java_lang_Boolean.marshall(_$178984759_isOther(a0), a1)).append(",").append("\"size\" : ").append(java_lang_Long.marshall(_$178984759_size(a0), a1)).append(",").append("\"fileKey\" : ").append(java_lang_Object.marshall(_$178984759_fileKey(a0), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.backend.vfs.impl.BasicAttributesVO", org_uberfire_backend_vfs_impl_BasicAttributesVO);
    org_uberfire_client_workbench_Position = new Marshaller<Position>() {
      private Position[] EMPTY_ARRAY = new Position[0];
      public Position[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return Position.class;
      }
      public Position demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          Position entity = obj != null ? Enum.valueOf(Position.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Position.class, a0.isString().stringValue()) : null;
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.client.workbench.Position", t);
        }
      }
      public String marshall(Position a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        return new StringBuilder(256).append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.client.workbench.Position\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
      }
    };
    marshallers.put("org.uberfire.client.workbench.Position", org_uberfire_client_workbench_Position);
    org_uberfire_backend_vfs_PathFactory$PathImpl = new Marshaller<PathImpl>() {
      private PathImpl[] EMPTY_ARRAY = new PathImpl[0];
      public PathImpl[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return PathImpl.class;
      }
      public PathImpl demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(PathImpl.class, objId);
          }
          PathImpl entity = new PathImpl();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("fs")) && (!obj.get("fs").isNull())) {
            _1656217245_fs(entity, (FileSystem) java_lang_Object.demarshall(FileSystem.class, obj.get("fs"), a1));
          }
          if ((obj.containsKey("uri")) && (!obj.get("uri").isNull())) {
            _1656217245_uri(entity, java_lang_String.demarshall(obj.get("uri"), a1));
          }
          if ((obj.containsKey("fileName")) && (!obj.get("fileName").isNull())) {
            _1656217245_fileName(entity, java_lang_String.demarshall(obj.get("fileName"), a1));
          }
          if ((obj.containsKey("attributes")) && (!obj.get("attributes").isNull())) {
            a1.setAssumedMapKeyType("java.lang.String");
            a1.setAssumedMapValueType("java.lang.Object");
            _1656217245_attributes(entity, (HashMap) java_util_HashMap.demarshall(obj.get("attributes"), a1));
            a1.setAssumedMapKeyType(null);
            a1.setAssumedMapValueType(null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.backend.vfs.PathFactory$PathImpl", t);
        }
      }
      public String marshall(PathImpl a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.PathFactory$PathImpl\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(640).append("{\"^EncodedType\":\"org.uberfire.backend.vfs.PathFactory$PathImpl\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"fs\" : ").append(java_lang_Object.marshall(_1656217245_fs(a0), a1)).append(",").append("\"uri\" : ").append(java_lang_String.marshall(_1656217245_uri(a0), a1)).append(",").append("\"fileName\" : ").append(java_lang_String.marshall(a0.getFileName(), a1)).append(",").append("\"attributes\" : ").append(java_util_HashMap.marshall(_1656217245_attributes(a0), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.backend.vfs.PathFactory$PathImpl", org_uberfire_backend_vfs_PathFactory$PathImpl);
    marshallers.put("org.uberfire.backend.vfs.PathFactory.PathImpl", org_uberfire_backend_vfs_PathFactory$PathImpl);
    java_lang_ArithmeticException = new Marshaller<ArithmeticException>() {
      private ArithmeticException[] EMPTY_ARRAY = new ArithmeticException[0];
      public ArithmeticException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ArithmeticException.class;
      }
      public ArithmeticException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ArithmeticException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ArithmeticException entity = new ArithmeticException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ArithmeticException", t);
        }
      }
      public String marshall(ArithmeticException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ArithmeticException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ArithmeticException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.ArithmeticException", java_lang_ArithmeticException);
    org_jboss_errai_bus_client_api_base_MessageDeliveryFailure = new Marshaller<MessageDeliveryFailure>() {
      private MessageDeliveryFailure[] EMPTY_ARRAY = new MessageDeliveryFailure[0];
      public MessageDeliveryFailure[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return MessageDeliveryFailure.class;
      }
      public MessageDeliveryFailure demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(MessageDeliveryFailure.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          MessageDeliveryFailure entity = new MessageDeliveryFailure(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jboss.errai.bus.client.api.base.MessageDeliveryFailure", t);
        }
      }
      public String marshall(MessageDeliveryFailure a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.MessageDeliveryFailure\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.MessageDeliveryFailure\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.jboss.errai.bus.client.api.base.MessageDeliveryFailure", org_jboss_errai_bus_client_api_base_MessageDeliveryFailure);
    org_jbpm_datamodeler_editor_model_ObjectPropertyTO = new Marshaller<ObjectPropertyTO>() {
      private ObjectPropertyTO[] EMPTY_ARRAY = new ObjectPropertyTO[0];
      public ObjectPropertyTO[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ObjectPropertyTO.class;
      }
      public ObjectPropertyTO demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ObjectPropertyTO.class, objId);
          }
          ObjectPropertyTO entity = new ObjectPropertyTO();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
            entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
          }
          if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
            entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jbpm.datamodeler.editor.model.ObjectPropertyTO", t);
        }
      }
      public String marshall(ObjectPropertyTO a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jbpm.datamodeler.editor.model.ObjectPropertyTO\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(384).append("{\"^EncodedType\":\"org.jbpm.datamodeler.editor.model.ObjectPropertyTO\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"className\" : ").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"name\" : ").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.jbpm.datamodeler.editor.model.ObjectPropertyTO", org_jbpm_datamodeler_editor_model_ObjectPropertyTO);
    org_uberfire_shared_mvp_impl_DefaultPlaceRequest = new Marshaller<DefaultPlaceRequest>() {
      private DefaultPlaceRequest[] EMPTY_ARRAY = new DefaultPlaceRequest[0];
      public DefaultPlaceRequest[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return DefaultPlaceRequest.class;
      }
      public DefaultPlaceRequest demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(DefaultPlaceRequest.class, objId);
          }
          DefaultPlaceRequest entity = new DefaultPlaceRequest();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("identifier")) && (!obj.get("identifier").isNull())) {
            _$753915497_identifier(entity, java_lang_String.demarshall(obj.get("identifier"), a1));
          }
          if ((obj.containsKey("parameters")) && (!obj.get("parameters").isNull())) {
            a1.setAssumedMapKeyType("java.lang.String");
            a1.setAssumedMapValueType("java.lang.String");
            _$753915497_parameters(entity, (Map) java_util_Map.demarshall(obj.get("parameters"), a1));
            a1.setAssumedMapKeyType(null);
            a1.setAssumedMapValueType(null);
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.shared.mvp.impl.DefaultPlaceRequest", t);
        }
      }
      public String marshall(DefaultPlaceRequest a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.shared.mvp.impl.DefaultPlaceRequest\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(384).append("{\"^EncodedType\":\"org.uberfire.shared.mvp.impl.DefaultPlaceRequest\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"identifier\" : ").append(java_lang_String.marshall(a0.getIdentifier(), a1)).append(",").append("\"parameters\" : ").append(java_util_Map.marshall(a0.getParameters(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.shared.mvp.impl.DefaultPlaceRequest", org_uberfire_shared_mvp_impl_DefaultPlaceRequest);
    org_uberfire_client_workbench_model_impl_PartDefinitionImpl = new Marshaller<PartDefinitionImpl>() {
      private PartDefinitionImpl[] EMPTY_ARRAY = new PartDefinitionImpl[0];
      public PartDefinitionImpl[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return PartDefinitionImpl.class;
      }
      public PartDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(PartDefinitionImpl.class, objId);
          }
          PartDefinitionImpl entity = new PartDefinitionImpl();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("place")) && (!obj.get("place").isNull())) {
            entity.setPlace((PlaceRequest) java_lang_Object.demarshall(PlaceRequest.class, obj.get("place"), a1));
          }
          if ((obj.containsKey("parentPanel")) && (!obj.get("parentPanel").isNull())) {
            entity.setParentPanel((PanelDefinition) java_lang_Object.demarshall(PanelDefinition.class, obj.get("parentPanel"), a1));
          }
          if ((obj.containsKey("isMinimized")) && (!obj.get("isMinimized").isNull())) {
            _$1782127567_isMinimized(entity, java_lang_Boolean.demarshall(obj.get("isMinimized"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.uberfire.client.workbench.model.impl.PartDefinitionImpl", t);
        }
      }
      public String marshall(PartDefinitionImpl a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.uberfire.client.workbench.model.impl.PartDefinitionImpl\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(512).append("{\"^EncodedType\":\"org.uberfire.client.workbench.model.impl.PartDefinitionImpl\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"place\" : ").append(java_lang_Object.marshall(a0.getPlace(), a1)).append(",").append("\"parentPanel\" : ").append(java_lang_Object.marshall(a0.getParentPanel(), a1)).append(",").append("\"isMinimized\" : ").append(java_lang_Boolean.marshall(_$1782127567_isMinimized(a0), a1)).append("}").toString();
      }
    };
    marshallers.put("org.uberfire.client.workbench.model.impl.PartDefinitionImpl", org_uberfire_client_workbench_model_impl_PartDefinitionImpl);
    arrayOf_java_lang_Object_D1 = new QualifyingMarshallerWrapper(new Marshaller<Object[]>() {
      public java.lang.Object[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Object[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Object[] newArray = new Object[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Object.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Object[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Object.class;
      }
      public Object[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Object[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Object;", arrayOf_java_lang_Object_D1);
    arrayOf_java_lang_String_D1 = new QualifyingMarshallerWrapper(new Marshaller<String[]>() {
      public java.lang.String[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private String[] _demarshall1(EJArray a0, MarshallingSession a1) {
        String[] newArray = new String[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_String.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(String[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return String.class;
      }
      public String[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(String[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.String;", arrayOf_java_lang_String_D1);
    arrayOf_int_D1 = new QualifyingMarshallerWrapper(new Marshaller<int[]>() {
      public int[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private int[] _demarshall1(EJArray a0, MarshallingSession a1) {
        int[] newArray = new int[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Integer.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(int[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return int.class;
      }
      public int[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(int[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[I", arrayOf_int_D1);
    arrayOf_long_D1 = new QualifyingMarshallerWrapper(new Marshaller<long[]>() {
      public long[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private long[] _demarshall1(EJArray a0, MarshallingSession a1) {
        long[] newArray = new long[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Long.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(long[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return long.class;
      }
      public long[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(long[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[J", arrayOf_long_D1);
    arrayOf_double_D1 = new QualifyingMarshallerWrapper(new Marshaller<double[]>() {
      public double[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private double[] _demarshall1(EJArray a0, MarshallingSession a1) {
        double[] newArray = new double[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Double.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(double[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return double.class;
      }
      public double[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(double[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[D", arrayOf_double_D1);
    arrayOf_float_D1 = new QualifyingMarshallerWrapper(new Marshaller<float[]>() {
      public float[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private float[] _demarshall1(EJArray a0, MarshallingSession a1) {
        float[] newArray = new float[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Float.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(float[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return float.class;
      }
      public float[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(float[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[F", arrayOf_float_D1);
    arrayOf_short_D1 = new QualifyingMarshallerWrapper(new Marshaller<short[]>() {
      public short[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private short[] _demarshall1(EJArray a0, MarshallingSession a1) {
        short[] newArray = new short[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Short.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(short[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return short.class;
      }
      public short[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(short[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[S", arrayOf_short_D1);
    arrayOf_boolean_D1 = new QualifyingMarshallerWrapper(new Marshaller<boolean[]>() {
      public boolean[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private boolean[] _demarshall1(EJArray a0, MarshallingSession a1) {
        boolean[] newArray = new boolean[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Boolean.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(boolean[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return boolean.class;
      }
      public boolean[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(boolean[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Z", arrayOf_boolean_D1);
    arrayOf_byte_D1 = new QualifyingMarshallerWrapper(new Marshaller<byte[]>() {
      public byte[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private byte[] _demarshall1(EJArray a0, MarshallingSession a1) {
        byte[] newArray = new byte[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Byte.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(byte[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return byte.class;
      }
      public byte[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(byte[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[B", arrayOf_byte_D1);
    arrayOf_char_D1 = new QualifyingMarshallerWrapper(new Marshaller<char[]>() {
      public char[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private char[] _demarshall1(EJArray a0, MarshallingSession a1) {
        char[] newArray = new char[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Character.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(char[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return char.class;
      }
      public char[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(char[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[C", arrayOf_char_D1);
    arrayOf_java_lang_Integer_D1 = new QualifyingMarshallerWrapper(new Marshaller<Integer[]>() {
      public java.lang.Integer[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Integer[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Integer[] newArray = new Integer[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Integer.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Integer[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Integer.class;
      }
      public Integer[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Integer[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Integer;", arrayOf_java_lang_Integer_D1);
    arrayOf_java_lang_Long_D1 = new QualifyingMarshallerWrapper(new Marshaller<Long[]>() {
      public java.lang.Long[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Long[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Long[] newArray = new Long[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Long.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Long[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Long.class;
      }
      public Long[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Long[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Long;", arrayOf_java_lang_Long_D1);
    arrayOf_java_lang_Double_D1 = new QualifyingMarshallerWrapper(new Marshaller<Double[]>() {
      public java.lang.Double[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Double[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Double[] newArray = new Double[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Double.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Double[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Double.class;
      }
      public Double[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Double[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Double;", arrayOf_java_lang_Double_D1);
    arrayOf_java_lang_Float_D1 = new QualifyingMarshallerWrapper(new Marshaller<Float[]>() {
      public java.lang.Float[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Float[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Float[] newArray = new Float[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Float.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Float[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Float.class;
      }
      public Float[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Float[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Float;", arrayOf_java_lang_Float_D1);
    arrayOf_java_lang_Short_D1 = new QualifyingMarshallerWrapper(new Marshaller<Short[]>() {
      public java.lang.Short[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Short[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Short[] newArray = new Short[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Short.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Short[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Short.class;
      }
      public Short[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Short[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Short;", arrayOf_java_lang_Short_D1);
    arrayOf_java_lang_Boolean_D1 = new QualifyingMarshallerWrapper(new Marshaller<Boolean[]>() {
      public java.lang.Boolean[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Boolean[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Boolean[] newArray = new Boolean[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Boolean.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Boolean[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Boolean.class;
      }
      public Boolean[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Boolean[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Boolean;", arrayOf_java_lang_Boolean_D1);
    arrayOf_java_lang_Byte_D1 = new QualifyingMarshallerWrapper(new Marshaller<Byte[]>() {
      public java.lang.Byte[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Byte[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Byte[] newArray = new Byte[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Byte.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Byte[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Byte.class;
      }
      public Byte[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Byte[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Byte;", arrayOf_java_lang_Byte_D1);
    arrayOf_java_lang_Character_D1 = new QualifyingMarshallerWrapper(new Marshaller<Character[]>() {
      public java.lang.Character[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Character[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Character[] newArray = new Character[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Character.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Character[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Character.class;
      }
      public Character[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Character[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Character;", arrayOf_java_lang_Character_D1);
  }

  private native static List _$1821390935_rootDirectories(FileSystemImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::rootDirectories;
  }-*/;

  private native static void _$1821390935_rootDirectories(FileSystemImpl instance, List value) /*-{
    instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::rootDirectories = value;
  }-*/;

  private native static Set _$1821390935_supportedViews(FileSystemImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::supportedViews;
  }-*/;

  private native static void _$1821390935_supportedViews(FileSystemImpl instance, Set value) /*-{
    instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::supportedViews = value;
  }-*/;

  private native static boolean _1257775948_isRoot(PanelDefinitionImpl instance) /*-{
    return instance.@org.uberfire.client.workbench.model.impl.PanelDefinitionImpl::isRoot;
  }-*/;

  private native static void _1257775948_isRoot(PanelDefinitionImpl instance, boolean value) /*-{
    instance.@org.uberfire.client.workbench.model.impl.PanelDefinitionImpl::isRoot = value;
  }-*/;

  private native static Set _1257775948_parts(PanelDefinitionImpl instance) /*-{
    return instance.@org.uberfire.client.workbench.model.impl.PanelDefinitionImpl::parts;
  }-*/;

  private native static void _1257775948_parts(PanelDefinitionImpl instance, Set value) /*-{
    instance.@org.uberfire.client.workbench.model.impl.PanelDefinitionImpl::parts = value;
  }-*/;

  private native static List _1257775948_children(PanelDefinitionImpl instance) /*-{
    return instance.@org.uberfire.client.workbench.model.impl.PanelDefinitionImpl::children;
  }-*/;

  private native static void _1257775948_children(PanelDefinitionImpl instance, List value) /*-{
    instance.@org.uberfire.client.workbench.model.impl.PanelDefinitionImpl::children = value;
  }-*/;

  private native static Path _$2135925616_path(Root instance) /*-{
    return instance.@org.uberfire.backend.Root::path;
  }-*/;

  private native static void _$2135925616_path(Root instance, Path value) /*-{
    instance.@org.uberfire.backend.Root::path = value;
  }-*/;

  private native static PlaceRequest _$2135925616_placeRequest(Root instance) /*-{
    return instance.@org.uberfire.backend.Root::placeRequest;
  }-*/;

  private native static void _$2135925616_placeRequest(Root instance, PlaceRequest value) /*-{
    instance.@org.uberfire.backend.Root::placeRequest = value;
  }-*/;

  private native static boolean _741338564_isTransient(PerspectiveDefinitionImpl instance) /*-{
    return instance.@org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl::isTransient;
  }-*/;

  private native static void _741338564_isTransient(PerspectiveDefinitionImpl instance, boolean value) /*-{
    instance.@org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl::isTransient = value;
  }-*/;

  private native static PanelDefinition _741338564_root(PerspectiveDefinitionImpl instance) /*-{
    return instance.@org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl::root;
  }-*/;

  private native static void _741338564_root(PerspectiveDefinitionImpl instance, PanelDefinition value) /*-{
    instance.@org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl::root = value;
  }-*/;

  private native static List _1281341560_content(DirectoryStreamImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.DirectoryStreamImpl::content;
  }-*/;

  private native static void _1281341560_content(DirectoryStreamImpl instance, List value) /*-{
    instance.@org.uberfire.backend.vfs.impl.DirectoryStreamImpl::content = value;
  }-*/;

  private native static Path _$1883331105_path(PathPlaceRequest instance) /*-{
    return instance.@org.uberfire.shared.mvp.impl.PathPlaceRequest::path;
  }-*/;

  private native static void _$1883331105_path(PathPlaceRequest instance, Path value) /*-{
    instance.@org.uberfire.shared.mvp.impl.PathPlaceRequest::path = value;
  }-*/;

  private native static String _$753915497_identifier(DefaultPlaceRequest instance) /*-{
    return instance.@org.uberfire.shared.mvp.impl.DefaultPlaceRequest::identifier;
  }-*/;

  private native static void _$753915497_identifier(DefaultPlaceRequest instance, String value) /*-{
    instance.@org.uberfire.shared.mvp.impl.DefaultPlaceRequest::identifier = value;
  }-*/;

  private native static Map _$753915497_parameters(DefaultPlaceRequest instance) /*-{
    return instance.@org.uberfire.shared.mvp.impl.DefaultPlaceRequest::parameters;
  }-*/;

  private native static void _$753915497_parameters(DefaultPlaceRequest instance, Map value) /*-{
    instance.@org.uberfire.shared.mvp.impl.DefaultPlaceRequest::parameters = value;
  }-*/;

  private native static boolean _$178984759_isRegularFile(BasicAttributesVO instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isRegularFile;
  }-*/;

  private native static void _$178984759_isRegularFile(BasicAttributesVO instance, boolean value) /*-{
    instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isRegularFile = value;
  }-*/;

  private native static boolean _$178984759_isDirectory(BasicAttributesVO instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isDirectory;
  }-*/;

  private native static void _$178984759_isDirectory(BasicAttributesVO instance, boolean value) /*-{
    instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isDirectory = value;
  }-*/;

  private native static boolean _$178984759_isSymbolicLink(BasicAttributesVO instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isSymbolicLink;
  }-*/;

  private native static void _$178984759_isSymbolicLink(BasicAttributesVO instance, boolean value) /*-{
    instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isSymbolicLink = value;
  }-*/;

  private native static boolean _$178984759_isOther(BasicAttributesVO instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isOther;
  }-*/;

  private native static void _$178984759_isOther(BasicAttributesVO instance, boolean value) /*-{
    instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::isOther = value;
  }-*/;

  private native static Long _$178984759_size(BasicAttributesVO instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::size;
  }-*/;

  private native static void _$178984759_size(BasicAttributesVO instance, Long value) /*-{
    instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::size = value;
  }-*/;

  private native static Object _$178984759_fileKey(BasicAttributesVO instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::fileKey;
  }-*/;

  private native static void _$178984759_fileKey(BasicAttributesVO instance, Object value) /*-{
    instance.@org.uberfire.backend.vfs.impl.BasicAttributesVO::fileKey = value;
  }-*/;

  private native static FileSystem _1656217245_fs(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::fs;
  }-*/;

  private native static void _1656217245_fs(PathImpl instance, FileSystem value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::fs = value;
  }-*/;

  private native static String _1656217245_uri(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::uri;
  }-*/;

  private native static void _1656217245_uri(PathImpl instance, String value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::uri = value;
  }-*/;

  private native static String _1656217245_fileName(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::fileName;
  }-*/;

  private native static void _1656217245_fileName(PathImpl instance, String value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::fileName = value;
  }-*/;

  private native static HashMap _1656217245_attributes(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::attributes;
  }-*/;

  private native static void _1656217245_attributes(PathImpl instance, HashMap value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::attributes = value;
  }-*/;

  private native static boolean _$1782127567_isMinimized(PartDefinitionImpl instance) /*-{
    return instance.@org.uberfire.client.workbench.model.impl.PartDefinitionImpl::isMinimized;
  }-*/;

  private native static void _$1782127567_isMinimized(PartDefinitionImpl instance, boolean value) /*-{
    instance.@org.uberfire.client.workbench.model.impl.PartDefinitionImpl::isMinimized = value;
  }-*/;

  public Marshaller getMarshaller(String a0, String a1) {
    return marshallers.get(a1);
  }
}