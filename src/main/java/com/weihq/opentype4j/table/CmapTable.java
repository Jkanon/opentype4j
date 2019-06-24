package com.weihq.opentype4j.table;


import com.weihq.opentype4j.AbstractParser;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.HashMap;
import java.util.Map;

/**
 * The "cmap" table of a font.
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class CmapTable extends AbstractParser<CmapTable> {
    /**
     * Table version number (0).
     */
    private int version;

    /**
     * Number of encoding tables that follow.
     */
    private int numTables;

    /**
     * Subtable format
     */
    private int format;

    /**
     * Byte length of this subtable
     */
    private int length;

    /**
     * For requirements on use of the language field
     */
    private int language;

    /**
     * Number of groupings which follow
     */
    private int groupCount;

    private Map<Integer, Integer> characterCodeToGlyphId = new HashMap<>();

    @Override
    protected void parse() {
        this.version = scriptObjectMirror.getIntValue("version");
        this.numTables = scriptObjectMirror.getIntValue("numTables");
        this.format = scriptObjectMirror.getIntValue("format");
        this.length = scriptObjectMirror.getIntValue("length");
        this.language = scriptObjectMirror.getIntValue("language");
        this.groupCount = scriptObjectMirror.getIntValue("groupCount");
        ScriptObjectMirror glyphIndexMap = scriptObjectMirror.get("glyphIndexMap");
        for (Map.Entry<String, Object> entry : glyphIndexMap.entrySet()) {
            int val = ((Number) entry.getValue()).intValue();
            this.characterCodeToGlyphId.put(Integer.parseInt(entry.getKey()), val);
        }
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getNumTables() {
        return numTables;
    }

    public void setNumTables(int numTables) {
        this.numTables = numTables;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public Map<Integer, Integer> getCharacterCodeToGlyphId() {
        return characterCodeToGlyphId;
    }

    public void setCharacterCodeToGlyphId(Map<Integer, Integer> characterCodeToGlyphId) {
        this.characterCodeToGlyphId = characterCodeToGlyphId;
    }
}
