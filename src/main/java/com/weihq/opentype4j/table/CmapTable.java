package com.weihq.opentype4j.table;


import com.weihq.opentype4j.AbstractParser;
import com.weihq.opentype4j.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
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

    private Map<String, Integer> characterCodeToGlyphId = new HashMap<>();

    @Override
    protected void parse() {
        this.version = fetchIntValue("version");
        this.numTables = fetchIntValue("numTables");
        this.format = fetchIntValue("format");
        this.length = fetchIntValue("length");
        this.language = fetchIntValue("language");
        this.groupCount = fetchIntValue("groupCount");
        this.characterCodeToGlyphId = fetch("glyphIndexMap");
    }
}
