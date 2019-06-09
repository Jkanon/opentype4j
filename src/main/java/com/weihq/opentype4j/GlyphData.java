package com.weihq.opentype4j;

import com.weihq.opentype4j.engine.ScriptObjectMirrorUtils;
import com.weihq.opentype4j.render.FontCell;
import com.weihq.opentype4j.table.HeadTable;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.List;

/**
 * A Glyph is an individual mark that often corresponds to a character.<br/>
 * Some glyphs, such as ligatures, are a combination of many characters.<br/>
 * Glyphs are the basic building blocks of a font.
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class GlyphData extends AbstractParser<GlyphData> {
    private Font font;

    private int index;

    private String name;

    private Integer unicode;

    private List<Integer> unicodes = new ArrayList<>();

    private int advanceWidth;

    private int leftSideBearing;

    private short xMin;

    private short yMin;

    private short xMax;

    private short yMax;

    private short numberOfContours;

    public Path getPath(double x, double y, double fontSize) {
        Path path = new Path().parse((ScriptObjectMirror) scriptObjectMirror.callMember("getPath", x, y, fontSize));
        path.setWidth(font.getHead().getxMax() - font.getHead().getxMin());
        path.setHeight(font.getHead().getyMax() - font.getHead().getyMin());

        return path;
    }

    public Path getPath(FontCell fontCell) {
        HeadTable head = font.getHead();
        double w = fontCell.getFontWidth();
        double h = fontCell.getFontHeight();
        double maxHeight = head.getyMax() - head.getyMin();
        double fontScale = Math.min(w / (head.getxMax() - head.getxMin()), h / maxHeight);
        double glyphWidth = (double) getAdvanceWidth() * fontScale;
        double xMin = (fontCell.getWidth() - glyphWidth) / 2;
        double fontBaseline = fontCell.getMarginTop() + h * head.getyMax() / maxHeight;
        double fontSize = fontScale * font.getUnitsPerEm();

        Path path = getPath(fontCell.getRelativeX() + xMin, fontCell.getRelativeY() + fontBaseline, fontSize);
        path.setWidth(fontCell.getWidth() + fontCell.getRelativeX());
        path.setHeight(fontCell.getHeight() + fontCell.getRelativeY());

        return path;
    }

    public Path getPath() {
        return getPath(new FontCell());
    }

    @Override
    protected void parse() {
        this.index = fetchIntValue("index");
        this.name = fetch("name");
        this.advanceWidth = fetchIntValue("advanceWidth");
        this.leftSideBearing = fetchIntValue("leftSideBearing");
        Object unicode = fetch("unicode");
        if (unicode != null && !ScriptObjectMirror.isUndefined(unicode)) {
            this.unicode = fetchIntValue("unicode");
        }
        ScriptObjectMirror unicodesList = fetch("unicodes");
        if (unicodesList != null) {
            int length = unicodesList.size();
            for (int i = 0; i < length; i++) {
                this.unicodes.add(ScriptObjectMirrorUtils.getObject(unicodesList, "" + i));
            }
        }
        this.xMax = fetchShortValue("xMax");
        this.yMax = fetchShortValue("yMax");
        this.xMin = fetchShortValue("xMin");
        this.yMin = fetchShortValue("yMin");
        this.numberOfContours = fetchShortValue("numberOfContours");
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
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

    public Integer getUnicode() {
        return unicode;
    }

    public void setUnicode(Integer unicode) {
        this.unicode = unicode;
    }

    public List<Integer> getUnicodes() {
        return unicodes;
    }

    public void setUnicodes(List<Integer> unicodes) {
        this.unicodes = unicodes;
    }

    public int getAdvanceWidth() {
        return advanceWidth;
    }

    public void setAdvanceWidth(int advanceWidth) {
        this.advanceWidth = advanceWidth;
    }

    public int getLeftSideBearing() {
        return leftSideBearing;
    }

    public void setLeftSideBearing(int leftSideBearing) {
        this.leftSideBearing = leftSideBearing;
    }

    public short getxMin() {
        return xMin;
    }

    public void setxMin(short xMin) {
        this.xMin = xMin;
    }

    public short getyMin() {
        return yMin;
    }

    public void setyMin(short yMin) {
        this.yMin = yMin;
    }

    public short getxMax() {
        return xMax;
    }

    public void setxMax(short xMax) {
        this.xMax = xMax;
    }

    public short getyMax() {
        return yMax;
    }

    public void setyMax(short yMax) {
        this.yMax = yMax;
    }

    public short getNumberOfContours() {
        return numberOfContours;
    }

    public void setNumberOfContours(short numberOfContours) {
        this.numberOfContours = numberOfContours;
    }

    @Override
    public String toString() {
        return "GlyphData{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", unicode=" + unicode +
                ", unicodes=" + unicodes +
                ", advanceWidth=" + advanceWidth +
                ", leftSideBearing=" + leftSideBearing +
                ", xMin=" + xMin +
                ", yMin=" + yMin +
                ", xMax=" + xMax +
                ", yMax=" + yMax +
                ", numberOfContours=" + numberOfContours +
                '}';
    }
}
