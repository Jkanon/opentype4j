package com.weihq.opentype4j.table;

import com.weihq.opentype4j.AbstractParser;

/**
 * The header `head`table
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
public class HeadTable extends AbstractParser<HeadTable> {
    private double version;
    private double fontRevision;
    private long checkSumAdjustment;
    private long magicNumber;
    private int flags;
    private int unitsPerEm;
    private long created;
    private long modified;
    private short xMin;
    private short yMin;
    private short xMax;
    private short yMax;
    private int macStyle;
    private int lowestRecPPEM;
    private short fontDirectionHint;
    private short indexToLocFormat;
    private short glyphDataFormat;

    @Override
    protected void parse() {
        this.version = scriptObjectMirror.getDoubleValue("version");
        this.fontRevision = scriptObjectMirror.getDoubleValue("fontRevision");
        this.checkSumAdjustment = scriptObjectMirror.getLongValue("checkSumAdjustment");
        this.magicNumber = scriptObjectMirror.getLongValue("magicNumber");
        this.flags = scriptObjectMirror.getIntValue("flags");
        this.unitsPerEm = scriptObjectMirror.getIntValue("unitsPerEm");
        this.created = scriptObjectMirror.getLongValue("created");
        this.modified = scriptObjectMirror.getLongValue("modified");
        this.xMin = scriptObjectMirror.getShortValue("xMin");
        this.yMin = scriptObjectMirror.getShortValue("yMin");
        this.xMax = scriptObjectMirror.getShortValue("xMax");
        this.yMax = scriptObjectMirror.getShortValue("yMax");
        this.macStyle = scriptObjectMirror.getIntValue("macStyle");
        this.lowestRecPPEM = scriptObjectMirror.getIntValue("lowestRecPPEM");
        this.fontDirectionHint = scriptObjectMirror.getShortValue("fontDirectionHint");
        this.indexToLocFormat = scriptObjectMirror.getShortValue("indexToLocFormat");
        this.glyphDataFormat = scriptObjectMirror.getShortValue("glyphDataFormat");
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public double getFontRevision() {
        return fontRevision;
    }

    public void setFontRevision(double fontRevision) {
        this.fontRevision = fontRevision;
    }

    public long getCheckSumAdjustment() {
        return checkSumAdjustment;
    }

    public void setCheckSumAdjustment(long checkSumAdjustment) {
        this.checkSumAdjustment = checkSumAdjustment;
    }

    public long getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(long magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getUnitsPerEm() {
        return unitsPerEm;
    }

    public void setUnitsPerEm(int unitsPerEm) {
        this.unitsPerEm = unitsPerEm;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getModified() {
        return modified;
    }

    public void setModified(long modified) {
        this.modified = modified;
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

    public int getMacStyle() {
        return macStyle;
    }

    public void setMacStyle(int macStyle) {
        this.macStyle = macStyle;
    }

    public int getLowestRecPPEM() {
        return lowestRecPPEM;
    }

    public void setLowestRecPPEM(int lowestRecPPEM) {
        this.lowestRecPPEM = lowestRecPPEM;
    }

    public short getFontDirectionHint() {
        return fontDirectionHint;
    }

    public void setFontDirectionHint(short fontDirectionHint) {
        this.fontDirectionHint = fontDirectionHint;
    }

    public short getIndexToLocFormat() {
        return indexToLocFormat;
    }

    public void setIndexToLocFormat(short indexToLocFormat) {
        this.indexToLocFormat = indexToLocFormat;
    }

    public short getGlyphDataFormat() {
        return glyphDataFormat;
    }

    public void setGlyphDataFormat(short glyphDataFormat) {
        this.glyphDataFormat = glyphDataFormat;
    }

    @Override
    public String toString() {
        return "HeadTable{" +
                "version=" + version +
                ", fontRevision=" + fontRevision +
                ", checkSumAdjustment=" + checkSumAdjustment +
                ", magicNumber=" + magicNumber +
                ", flags=" + flags +
                ", unitsPerEm=" + unitsPerEm +
                ", created=" + created +
                ", modified=" + modified +
                ", xMin=" + xMin +
                ", yMin=" + yMin +
                ", xMax=" + xMax +
                ", yMax=" + yMax +
                ", macStyle=" + macStyle +
                ", lowestRecPPEM=" + lowestRecPPEM +
                ", fontDirectionHint=" + fontDirectionHint +
                ", indexToLocFormat=" + indexToLocFormat +
                ", glyphDataFormat=" + glyphDataFormat +
                '}';
    }
}
