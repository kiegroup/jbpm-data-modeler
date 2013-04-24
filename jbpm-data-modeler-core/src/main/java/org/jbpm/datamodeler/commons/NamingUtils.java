package org.jbpm.datamodeler.commons;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NamingUtils {

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


    public static void main(String args[]) {
        System.out.println(getInstance().extractClassName("java.lang.Integer"));
        System.out.println(getInstance().extractClassName("Integer"));

        System.out.println(getInstance().extractPackageName("java.lang.Integer"));
        System.out.println(getInstance().extractPackageName("Integer"));
        List tokens = getInstance().tokenizePackageName(getInstance().extractPackageName("java.lang.Integer"));
        tokens = getInstance().tokenizePackageName(getInstance().extractPackageName("lang.Integer"));

        tokens = getInstance().tokenizePackageName(getInstance().extractPackageName("Integer"));
        tokens = getInstance().tokenizePackageName("java");
        tokens = getInstance().tokenizePackageName("java.lang.myclasses");
        tokens = null;
    }
    
}
