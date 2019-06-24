package com.weihq.opentype4j;

import com.weihq.opentype4j.engine.ScriptObjectMirrorWrapper;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * Abstract class for converting javascript object to java object
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public abstract class AbstractParser<T extends AbstractParser<T>> {
    protected ScriptObjectMirrorWrapper scriptObjectMirror = null;

    @SuppressWarnings("unchecked")
    protected T parse(ScriptObjectMirror obj) {
        if (obj == null) {
            return null;
        }
        scriptObjectMirror = new ScriptObjectMirrorWrapper(obj);
        parse();
        return (T) this;
    }

    abstract protected void parse();
}
