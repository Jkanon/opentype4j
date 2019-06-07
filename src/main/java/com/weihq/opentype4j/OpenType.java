package com.weihq.opentype4j;

import com.weihq.opentype4j.engine.JavaScriptEngine;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Entry for parsing font file
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class OpenType {
    private static final String JS_NAME = "opentype.js";

    private static final String JS_PATH = OpenType.class.getResource("/" + JS_NAME).getPath();

    private static CompiledScript compiledScript = null;

    public static Font parse(String path) throws IOException, ScriptException{
        return parse(new File(path));
    }

    public static Font parse(File file) throws IOException, ScriptException{
        return parse(Files.readAllBytes(file.toPath()));
    }

    public static Font parse(byte[] bytes) throws IOException, ScriptException {
        if (compiledScript == null) {
            synchronized (OpenType.class) {
                if (compiledScript == null) {
                    compiledScript = JavaScriptEngine.getInstance().compile(new FileReader(JS_PATH));
                }
            }
        }
        ScriptContext ctx = new SimpleScriptContext();
        ctx.setAttribute("$bytes", bytes, ScriptContext.ENGINE_SCOPE);
        ScriptObjectMirror jsFont = (ScriptObjectMirror) compiledScript.eval(ctx);
        return new Font().parse(jsFont);
    }
}
