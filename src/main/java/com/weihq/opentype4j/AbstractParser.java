package com.weihq.opentype4j;

import com.weihq.opentype4j.engine.ScriptObjectMirrorUtils;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * Interface for converting javascript object to java object
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public abstract class AbstractParser<T extends AbstractParser<T>> {
    protected ScriptObjectMirror scriptObjectMirror = null;

    public T parse(ScriptObjectMirror obj) {
        if (obj == null) {
            return null;
        }
        scriptObjectMirror = obj;
        parse();
        return (T) this;
    }

    abstract protected void parse();

    protected <E> E fetch(String key) {
        return ScriptObjectMirrorUtils.getObject(scriptObjectMirror, key);
    }

    protected int fetchIntValue(String key) {
        return ScriptObjectMirrorUtils.getInt(scriptObjectMirror, key);
    }

    protected boolean fetchBooleanValue(String key) {
        return Boolean.TRUE.equals(fetch(key));
    }
}
