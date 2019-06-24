package com.weihq.opentype4j;

import java.util.List;

/**
 * A bounding box is an enclosing box that describes the smallest measure within which all the points lie.
 * It is used to calculate the bounding box of a glyph or text path.
 *
 * @author Jkanon
 * @date 2019/06/08
 **/
public class BoundingBox extends AbstractParser<BoundingBox> {
    private double lowerLeftX;

    private double lowerLeftY;

    private double upperRightX;

    private double upperRightY;

    /**
     * Default constructor.
     */
    public BoundingBox() {
    }

    /**
     * Constructor.
     *
     * @param minX lower left x value
     * @param minY lower left y value
     * @param maxX upper right x value
     * @param maxY upper right y value
     */
    public BoundingBox(double minX, double minY, double maxX, double maxY) {
        lowerLeftX = minX;
        lowerLeftY = minY;
        upperRightX = maxX;
        upperRightY = maxY;
    }

    /**
     * Constructor.
     *
     * @param numbers list of four numbers
     */
    public BoundingBox(List<Number> numbers) {
        lowerLeftX = numbers.get(0).doubleValue();
        lowerLeftY = numbers.get(1).doubleValue();
        upperRightX = numbers.get(2).doubleValue();
        upperRightY = numbers.get(3).doubleValue();
    }

    /**
     * This will get the width of this rectangle as calculated by
     * upperRightX - lowerLeftX.
     *
     * @return The width of this rectangle.
     */
    public double getWidth() {
        return getUpperRightX() - getLowerLeftX();
    }

    /**
     * This will get the height of this rectangle as calculated by
     * upperRightY - lowerLeftY.
     *
     * @return The height of this rectangle.
     */
    public double getHeight() {
        return getUpperRightY() - getLowerLeftY();
    }

    /**
     * Checks if a point is inside this rectangle.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return true If the point is on the edge or inside the rectangle bounds.
     */
    public boolean contains(double x, double y) {
        return x >= lowerLeftX && x <= upperRightX &&
                y >= lowerLeftY && y <= upperRightY;
    }

    @Override
    protected void parse() {
        this.lowerLeftX = scriptObjectMirror.get("x1");
        this.upperRightX = scriptObjectMirror.get("x2");
        this.lowerLeftY = scriptObjectMirror.get("y1");
        this.upperRightY = scriptObjectMirror.get("y2");
    }

    public double getLowerLeftX() {
        return lowerLeftX;
    }

    public void setLowerLeftX(double lowerLeftXValue) {
        this.lowerLeftX = lowerLeftXValue;
    }

    public double getLowerLeftY() {
        return lowerLeftY;
    }

    public void setLowerLeftY(double lowerLeftYValue) {
        this.lowerLeftY = lowerLeftYValue;
    }

    public double getUpperRightX() {
        return upperRightX;
    }

    public void setUpperRightX(double upperRightXValue) {
        this.upperRightX = upperRightXValue;
    }

    public double getUpperRightY() {
        return upperRightY;
    }

    public void setUpperRightY(double upperRightYValue) {
        this.upperRightY = upperRightYValue;
    }

    /**
     * This will return a string representation of this rectangle.
     *
     * @return This object as a string.
     */
    @Override
    public String toString() {
        return "[" + getLowerLeftX() + "," + getLowerLeftY() + "," +
                getUpperRightX() + "," + getUpperRightY() + "]";
    }
}
