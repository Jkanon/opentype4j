package com.weihq.opentype4j.render;

/**
 * A FontCell defines an outer bounds where a font will be rendered in
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
public class FontCell {
    private double width = 44;

    private double height = 40;

    private double marginLeftRight = 1;

    private double marginTop = 1;

    private double marginBottom = 8;

    private double relativeX = 0;

    private double relativeY = 0;

    public FontCell() {
    }

    public FontCell(int width, int height) {
        double scale = Math.min(width / this.width, height / this.height);
        this.marginLeftRight = (int) scale * this.marginLeftRight;
        this.marginTop = (int) scale * this.marginTop;
        this.marginBottom = (int) scale * this.marginBottom;
        this.width = width;
        this.height = height;
    }

    public FontCell(double width, double height, double relativeX, double relativeY) {
        this.width = width;
        this.height = height;
        this.relativeX = relativeX;
        this.relativeY = relativeY;
    }

    public double getFontWidth() {
        return width - marginLeftRight * 2;
    }

    public double getFontHeight() {
        return height - marginTop - marginBottom;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMarginLeftRight() {
        return marginLeftRight;
    }

    public void setMarginLeftRight(double marginLeftRight) {
        this.marginLeftRight = marginLeftRight;
    }

    public double getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(double marginTop) {
        this.marginTop = marginTop;
    }

    public double getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(double marginBottom) {
        this.marginBottom = marginBottom;
    }

    public double getRelativeX() {
        return relativeX;
    }

    public void setRelativeX(double relativeX) {
        this.relativeX = relativeX;
    }

    public double getRelativeY() {
        return relativeY;
    }

    public void setRelativeY(double relativeY) {
        this.relativeY = relativeY;
    }

    @Override
    public String toString() {
        return "FontCell{" +
                "width=" + width +
                ", height=" + height +
                ", marginLeftRight=" + marginLeftRight +
                ", marginTop=" + marginTop +
                ", marginBottom=" + marginBottom +
                ", relativeX=" + relativeX +
                ", relativeY=" + relativeY +
                '}';
    }
}
