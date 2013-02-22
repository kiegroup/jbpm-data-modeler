package org.jbpm.datamodeler.codegen;

/**
 * Helper tools to generate names easily from templates
 */
public class GenerationTools {


    public String fitToSize(int size, String name, char padChar) {
        int n = size - name.length();

        StringBuffer buf = new StringBuffer();

        buf.append(name);

        for (int i = 0; i < n; i++) {
            buf.append(padChar);
        }

        return buf.toString();
    }

    public String toJavaClass(String name) {

        return toJavaName(name, true);
    }

    public String toJavaMethod(String name) {

        return toJavaName(name, false);
    }

    public String toJavaGetter(String name) {

        return "get" + toJavaName(name, true);
    }

    public String toJavaSetter(String name) {

        return "set" + toJavaName(name, true);
    }

    private String toJavaName(String name, boolean firstLetterIsUpperCase) {

        name = name.toLowerCase();

        StringBuffer res = new StringBuffer();

        boolean nextIsUpperCase = firstLetterIsUpperCase;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if (nextIsUpperCase) {
                c = Character.toUpperCase(c);
            }

            if (Character.isLetter(c)) {
                res.append(c);
                nextIsUpperCase = false;
            } else {
                nextIsUpperCase = true;
            }
        }

        return res.toString();
    }

    public String toJavaVar(String name) {
        return toJavaName(name, false);
    }
}
