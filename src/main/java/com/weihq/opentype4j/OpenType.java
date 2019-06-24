package com.weihq.opentype4j;

import com.weihq.opentype4j.engine.JavaScriptEngine;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import java.io.*;
import java.nio.file.Files;

/**
 * Entry for parsing font file
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class OpenType {
    private static final String JS_NAME = "opentype.js";

    private static CompiledScript compiledScript = null;

    public static Font parse(String path) throws IOException {
        return parse(new File(path));
    }

    public static Font parse(File file) throws IOException {
        return parse(Files.readAllBytes(file.toPath()));
    }

    public static Font parse(byte[] bytes) throws IOException {
        try {
            if (compiledScript == null) {
                synchronized (OpenType.class) {
                    if (compiledScript == null) {
                        compiledScript = JavaScriptEngine.compile(
                                new BufferedReader(new InputStreamReader(OpenType.class.getResourceAsStream("/" + JS_NAME)))
                        );
                    }
                }
            }
            ScriptContext ctx = new SimpleScriptContext();
            ctx.setAttribute("$bytes", bytes, ScriptContext.ENGINE_SCOPE);
            ScriptObjectMirror jsFont = (ScriptObjectMirror) compiledScript.eval(ctx);
            return new Font().parse(jsFont);
        } catch (ScriptException e) {
            throw new IOException(e);
        }
    }
}
