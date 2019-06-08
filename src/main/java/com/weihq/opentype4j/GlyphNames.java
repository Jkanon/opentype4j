package com.weihq.opentype4j;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Glyph names wrapper
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
public class GlyphNames extends AbstractParser<GlyphNames> {
    private List<String> names;

    /**
     * Gets the index of a glyph by name.
     * @param name Glyph name
     * @return
     */
    public Integer nameToGlyphIndex(String name) {
        return this.names.indexOf(name);
    }

    /**
     * Gets the glyph name by index
     * @param glyId Glyph index
     * @return
     */
    public String glyphIndexToName(int glyId) {
        return this.names.get(glyId);
    }

    @Override
    protected void parse() {
        ScriptObjectMirror names = fetch("names");
        this.names = new ArrayList<>(names.size());
        for (Map.Entry<String, Object> entry : names.entrySet()) {
            this.names.add(Integer.parseInt(entry.getKey()), (String) entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "GlyphNames{" +
                "names=" + names +
                '}';
    }
}
