package net.liuzd.util.lang;

public class StringUtils {

    public static boolean isBlank(String val) {
        return null == val || val.isEmpty() || val.length() == 0;
    }

    public static String defaultString(String val) {
        return null == val ? "" : val;
    }

}
