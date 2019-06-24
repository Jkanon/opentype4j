package com.weihq.opentype4j;

/**
 * A dictionary containing a type and coordinates.
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class Command extends AbstractParser<Command> {
    private String type;

    private Double x;

    private Double y;

    @Override
    protected void parse() {
        this.type = scriptObjectMirror.get("type");
        this.x = scriptObjectMirror.getDouble("x");
        this.y = scriptObjectMirror.getDouble("y");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Command{" +
                "type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
