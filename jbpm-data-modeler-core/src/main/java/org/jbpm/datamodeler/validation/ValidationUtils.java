package org.jbpm.datamodeler.validation;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

import javax.lang.model.SourceVersion;

public class ValidationUtils {

    public static Boolean isJavaIdentifier(String s) {
        if (StringUtils.isBlank(s)) return false;
        if (!SourceVersion.isName(s)) return false;
        for (int i = 1; i < s.length(); i++) {
            if (!CharUtils.isAsciiPrintable(s.charAt(i))) return false;
        }
        return true;
    }
}
