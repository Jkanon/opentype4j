package com.weihq.opentype4j.util;

/**
 * String Utilities
 *
 * @author Jkanon
 * @date 2019/06/04
 **/
public class StringUtils {
    private StringUtils(){}

    public static String fromCharCode(int... codePoints) {
        return new String(codePoints, 0, codePoints.length);
    }

    public static String bytesToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i += 1) {
            sb.append(fromCharCode((int) bytes[i]));
        }

        return sb.toString();
    }
}
