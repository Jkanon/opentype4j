package com.weihq.opentype4j;

import com.weihq.opentype4j.engine.ScriptObjectMirrorUtils;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class GlyphDataList extends AbstractParser<GlyphDataList> {

    private int length;

    private List<GlyphData> glyphs = new ArrayList<>();

    @Override
    protected void parse() {
        ScriptObjectMirror glyphsList = fetch("glyphs");
        if (glyphsList != null) {
            this.length = glyphsList.size();
            for (int i = 0; i < length; i++) {
                this.glyphs.add(new GlyphData().parse(ScriptObjectMirrorUtils.getObject(glyphsList, ""+i)));
            }
        }
    }

    public GlyphData get(int index) {
        return glyphs.get(index);
    }

    @Override
    public String toString() {
        return "GlyphDataList{" +
                "length=" + length +
                ", glyphs=" + glyphs +
                '}';
    }
}
