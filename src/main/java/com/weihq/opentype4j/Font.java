package com.weihq.opentype4j;

import com.weihq.opentype4j.table.CmapTable;
import com.weihq.opentype4j.util.StringUtils;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.HashMap;
import java.util.Map;

/**
 * An OpenType font file
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class Font extends AbstractParser<Font> {

    private int numGlyphs;

    private boolean isCIDFont = false;

    private int defaultWidthX;

    private int nominalWidthX;

    private int unitsPerEm;

    private int ascender;

    private int descender;

    private String outlinesFormat;

    private GlyphDataList glyphs;

    private Map<String, Object> tables = new HashMap<>();

    @Override
    protected void parse() {
        this.numGlyphs = fetchIntValue("numGlyphs");
        this.isCIDFont = fetchBooleanValue("isCIDFont");
        this.defaultWidthX = fetchIntValue("defaultWidthX");
        this.nominalWidthX = fetchIntValue("nominalWidthX");
        this.unitsPerEm = fetchIntValue("unitsPerEm");
        this.ascender = fetchIntValue("ascender");
        this.descender = fetchIntValue("descender");
        this.outlinesFormat = fetch("outlinesFormat");
        this.glyphs = new GlyphDataList().parse(fetch("glyphs"));
        ScriptObjectMirror tables = fetch("tables");

        this.tables.put("cmap", new CmapTable().parse((ScriptObjectMirror) tables.get("cmap")));
    }

    public CmapTable getCamp() {
        return (CmapTable) tables.get("cmap");
    }

    public int charToGlyphIndex(int charCode) {
        Integer index = (Integer) scriptObjectMirror.callMember("charToGlyphIndex", StringUtils.fromCharCode(charCode));
        if (index == null) {
            return -1;
        }

        return index;
    }

    public GlyphData charToGlyph(int charCode) {
        int index = charToGlyphIndex(charCode);
        GlyphData glyphData = glyphs.get(index);
        if (glyphData == null) {
            //.notdef
            return glyphs.get(0);
        }
        return glyphData;
    }

    public GlyphDataList getGlyphs() {
        return glyphs;
    }

    public void setGlyphs(GlyphDataList glyphs) {
        this.glyphs = glyphs;
    }
}
