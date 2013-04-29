package org.jbpm.datamodeler.validation;

import java.util.Arrays;

public class ValidationUtils {
    private static String[] JAVA_KEYWORDS = {
            "abstract", "continue", "for", "new", "switch", "assert",
            "default", "if", "package", "synchronized", "boolean", "do",
            "goto", "private", "this", "break", "double", "implements",
            "protected", "throw", "byte", "else", "import", "public",
            "throws", "case", "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try", "char",
            "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native",
            "super", "while"};

    public static Boolean isJavaIdentifier(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) return false;
        if (!Character.isJavaIdentifierStart(s.charAt(0))) return false;
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isJavaIdentifierPart(s.charAt(i))) return false;
        }
        return !Arrays.asList(JAVA_KEYWORDS).contains(s);
    }
}
