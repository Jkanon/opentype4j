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
public class GlyphData extends AbstractParser<GlyphData> {
    private int index;

    private String name;

    private int unicode;

    private List<Integer> unicodes = new ArrayList<>();

    private int advancedWidth;

    private int leftSideBearing;

    @Override
    protected void parse() {
        this.index = fetchIntValue( "index");
        this.name = fetch("name");
        this.advancedWidth = fetchIntValue("advancedWidth");
        this.leftSideBearing = fetchIntValue("leftSideBearing");
        this.unicode = fetchIntValue("unicode");
        ScriptObjectMirror unicodesList = fetch( "unicodes");
        if (unicodesList != null) {
            int length = unicodesList.size();
            for (int i = 0; i < length; i++) {
                this.unicodes.add(ScriptObjectMirrorUtils.getObject(unicodesList, "" + i));
            }
        }
    }

    public Path getPath() {
        return new Path().parse((ScriptObjectMirror) scriptObjectMirror.callMember("getPath", 0, 60));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnicode() {
        return unicode;
    }

    public void setUnicode(int unicode) {
        this.unicode = unicode;
    }

    public List<Integer> getUnicodes() {
        return unicodes;
    }

    public void setUnicodes(List<Integer> unicodes) {
        this.unicodes = unicodes;
    }

    public int getAdvancedWidth() {
        return advancedWidth;
    }

    public void setAdvancedWidth(int advancedWidth) {
        this.advancedWidth = advancedWidth;
    }

    public int getLeftSideBearing() {
        return leftSideBearing;
    }

    public void setLeftSideBearing(int leftSideBearing) {
        this.leftSideBearing = leftSideBearing;
    }

    @Override
    public String toString() {
        return "GlyphData{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", unicode=" + unicode +
                ", unicodes=" + unicodes +
                ", advancedWidth=" + advancedWidth +
                ", leftSideBearing=" + leftSideBearing +
                '}';
    }
}
