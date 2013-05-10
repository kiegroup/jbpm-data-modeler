package org.jbpm.datamodeler.commons;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NamingUtils {

    public static final String BYTE  = "byte";
    public static final String SHORT = "short";
    public static final String INT = "int";
    public static final String LONG = "long";
    public static final String FLOAT = "float";
    public static final String DOUBLE = "double";
    public static final String CHAR = "char";
    public static final String BOOLEAN = "boolean";

    public static NamingUtils getInstance() {
        return new NamingUtils();
    }

    public String extractClassName(String fullClassName) {

        if (fullClassName == null) return null;
        int index = fullClassName.lastIndexOf(".");
        if (index > 0) {
            return fullClassName.substring(index+1, fullClassName.length());

        } else {
            return fullClassName;
        }
    }

    public String extractPackageName(String fullClassName) {
        if (fullClassName == null) return null;
        int index = fullClassName.lastIndexOf(".");
        if (index > 0) {
            return fullClassName.substring(0, index);

        } else {
            return null;
        }
    }

    public List<String> tokenizePackageName(String packageName) {
        List<String> tokens = new ArrayList<String>();

        if (packageName != null) {
            StringTokenizer st = new StringTokenizer(packageName, ".");
            while (st.hasMoreTokens()) {
                tokens.add(st.nextToken());
            }
        }
        return tokens;
    }

    public boolean isPrimitiveTypeClass(String className) {
        //returns true for: byte, short, int, long, float, double, char, boolean

        return
                Byte.class.getName().equals(className) ||
                Short.class.getName().equals(className) ||
                Integer.class.getName().equals(className) ||
                Long.class.getName().equals(className) ||
                Float.class.getName().equals(className) ||
                Double.class.getName().equals(className) ||
                Character.class.getName().equals(className) ||
                Boolean.class.getName().equals(className);
    }

    public boolean isPrimitiveTypeId(String type) {
        //returns true for: byte, short, int, long, float, double, char, boolean
        return
            BYTE.equals(type) ||
            SHORT.equals(type) ||
            INT.equals(type) ||
            LONG.equals(type) ||
            FLOAT.equals(type) ||
            DOUBLE.equals(type) ||
            CHAR.equals(type) ||
            BOOLEAN.equals(type);
    }

    public String getClassForPrimitiveTypeId(String type) {

        if (BYTE.equals(type)) return Byte.class.getName();
        if (SHORT.equals(type)) return Short.class.getName();
        if (INT.equals(type)) return Integer.class.getName();
        if (LONG.equals(type)) return Long.class.getName();
        if (FLOAT.equals(type)) return Float.class.getName();
        if (DOUBLE.equals(type)) return Double.class.getName();
        if (CHAR.equals(type)) return Character.class.getName();
        if (BOOLEAN.equals(type)) return Boolean.class.getName();

        return null;
    }
    
}
