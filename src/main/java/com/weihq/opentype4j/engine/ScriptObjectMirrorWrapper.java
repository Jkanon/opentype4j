package com.weihq.opentype4j.engine;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.Arrays;

/**
 * @author Jkanon
 * @date 2019/06/24
 **/
public class ScriptObjectMirrorWrapper {
    private ScriptObjectMirror scriptObjectMirror;

    public ScriptObjectMirrorWrapper(ScriptObjectMirror scriptObjectMirror) {
        this.scriptObjectMirror = scriptObjectMirror;
    }

    public Object callMember(String functionName, Object... args) {
        ScriptObjectMirror func = (ScriptObjectMirror)scriptObjectMirror.get(functionName);
        if (args.length == 0) {
            return func.call(scriptObjectMirror);
        }
        return func.call(scriptObjectMirror, args);
    }

    @SuppressWarnings("unchecked")
    public <E> E get(String key) {
        return (E) scriptObjectMirror.get(key);
    }

    public Short getShort(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return null;
        }

        return ((Number) value).shortValue();
    }

    public short getShortValue(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return 0;
        }

        return ((Number) value).shortValue();
    }

    public Integer getInt(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return null;
        }

        return ((Number) value).intValue();
    }

    public int getIntValue(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return 0;
        }

        return ((Number) value).intValue();
    }

    public Long getLong(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return null;
        }

        return ((Number) value).longValue();
    }

    public long getLongValue(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return 0;
        }

        return ((Number) value).longValue();
    }

    public Double getDouble(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return null;
        }

        return ((Number) value).doubleValue();
    }

    public double getDoubleValue(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null || !Number.class.isAssignableFrom(value.getClass())) {
            return 0;
        }

        return ((Number) value).doubleValue();
    }

    public Boolean getBoolean(String key) {
        Object value = scriptObjectMirror.get(key);
        if (value == null) {
            return null;
        }
        return Boolean.TRUE.equals(value);
    }

    public boolean getBooleanValue(String key) {
        return Boolean.TRUE.equals(scriptObjectMirror.get(key));
    }

    public ScriptObjectMirror get() {
        return scriptObjectMirror;
    }
}
