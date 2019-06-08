package com.weihq.opentype4j.engine;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * Script Utilities
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class ScriptObjectMirrorUtils {
    @SuppressWarnings("unchecked")
    public static <T> T getObject(ScriptObjectMirror obj, String key) {
        return (T) obj.get(key);
    }

    public static int getInt(ScriptObjectMirror obj, String key) {
        Object val = obj.get(key);
        if (val == null) {
            return 0;
        }
        if (val instanceof Double) {
            return ((Double) val).intValue();
        }
        if (val instanceof Long) {
            return ((Long) val).intValue();
        }
        return (Integer) val;
    }

    public static short getShort(ScriptObjectMirror obj, String key) {
        Object val = obj.get(key);
        if (val == null) {
            return 0;
        }
        if (val instanceof Double) {
            return ((Double) val).shortValue();
        }
        if (val instanceof Long) {
            return ((Long) val).shortValue();
        }
        return (Short) val;
    }

    public static long getLong(ScriptObjectMirror obj, String key) {
        Object val = obj.get(key);
        if (val == null) {
            return 0;
        }
        if (val instanceof Double) {
            return ((Double) val).longValue();
        }

        return (Long) val;
    }
}
