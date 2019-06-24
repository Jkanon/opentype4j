package com.weihq.opentype4j;

import com.weihq.opentype4j.engine.ScriptObjectMirrorUtils;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of {@link GlyphData}
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class GlyphDataList extends AbstractParser<GlyphDataList> {

    private int length;

    private List<GlyphData> glyphs = new ArrayList<>();

    private Font font;

    @Override
    protected void parse() {
        ScriptObjectMirror glyphsList = scriptObjectMirror.get("glyphs");
        if (glyphsList != null) {
            this.length = glyphsList.size();
            for (int i = 0; i < length; i++) {
                GlyphData glyph = new GlyphData().parse(ScriptObjectMirrorUtils.getObject(glyphsList, ""+i));
                glyph.setFont(this.font);
                this.glyphs.add(glyph);
            }
        }
    }

    public int getLength() {
        return length;
    }

    public GlyphData get(int index) {
        return glyphs.get(index);
    }

    public List<GlyphData> getGlyphs() {
        return glyphs;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    @Override
    public String toString() {
        return "GlyphDataList{" +
                "length=" + length +
                ", glyphs=" + glyphs +
                '}';
    }
}
