package com.weihq.opentype4j.engine;

import javax.script.*;
import java.io.Reader;

/**
 * Javascript engine wrapper
 *
 * @author weihq
 * @date 2019/04/05
 **/
public class JavaScriptEngine {
    private ScriptEngine engine;

    private static class JavaScriptEngineHolder {
        private static final JavaScriptEngine INSTANCE = new JavaScriptEngine();
    }

    public static JavaScriptEngine getInstance() {
        return JavaScriptEngineHolder.INSTANCE;
    }

    private JavaScriptEngine() {
        this.engine = new ScriptEngineManager().getEngineByName("javascript");
    }

    public Object eval(String expression, ScriptContext ctx) throws ScriptException {
        return engine.eval(expression, ctx);
    }

    public Object eval(Reader reader, ScriptContext ctx) throws ScriptException {
        return engine.eval(reader, ctx);
    }

    public CompiledScript compile(String expression) throws ScriptException {
        return  ((Compilable)engine).compile(expression);
    }

    public CompiledScript compile(Reader reader) throws ScriptException {
        return  ((Compilable)engine).compile(reader);
    }

}
