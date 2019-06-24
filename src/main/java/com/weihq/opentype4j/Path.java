package com.weihq.opentype4j;

import com.weihq.opentype4j.render.ImageFormat;
import com.weihq.opentype4j.util.SVGUtils;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Path containing a set of path commands similar to a SVG path.
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class Path extends AbstractParser<Path> {
    private List<Command> commands = new ArrayList<>();

    private String fill;

    private String stroke;

    private int strokeWidth;

    private double width;

    private double height;

    /**
     * Convert the path to a string of svg dom.
     *
     * @return
     */
    public String toSVG() {
        return "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                "<svg width=\"" + (width <= 0 ? "100%" : width) + "\" height=\"" + (height <= 0 ? "100%" : height) + "\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                toSVGPath() +
                "\n</svg>";
    }

    /**
     * Save the path to a svg file
     *
     * @param path The path of svg file
     * @throws IOException
     */
    public void toSVG(String path) throws IOException {
        SVGUtils.writeToSVG(new File(path), toSVG());
    }

    /**
     * Convert the Path to a string of svg path data.
     *
     * @return
     */
    public String toSVGPath() {
        return (String) scriptObjectMirror.callMember("toSVG");
    }

    /**
     * Convert the path to a image file
     *
     * @param file
     * @throws IOException
     */
    public void toImage(File file) throws IOException {
        toImage(file, ImageFormat.JPEG);
    }

    /**
     * Convert the path to a image file with specified format
     *
     * @param file
     * @throws IOException
     */
    public void toImage(File file, ImageFormat format) throws IOException {
        ByteArrayInputStream is = new ByteArrayInputStream(toSVG().getBytes());
        FileOutputStream fs = new FileOutputStream(file);
        SVGUtils.converSVGToImage(is, fs, format);
    }

    /**
     * Convert the path to a image bytes
     *
     * @throws IOException
     */
    public byte[] toImageBytes() throws IOException {
        return toImageBytes(ImageFormat.JPEG);
    }

    /**
     * Convert the path to byte array of the image
     *
     * @param format
     * @return
     * @throws IOException
     */
    public byte[] toImageBytes(ImageFormat format) throws IOException {
        ByteArrayInputStream is = new ByteArrayInputStream(toSVG().getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SVGUtils.converSVGToImage(is, os, format);
        return os.toByteArray();
    }

    /**
     * Calculate the bounding box of the path.
     *
     * @return
     */
    public BoundingBox getBoundingBox() {
        return new BoundingBox().parse((ScriptObjectMirror) scriptObjectMirror.callMember("getBoundingBox"));
    }

    public Path extend(Path input) {
        this.commands.addAll(input.getCommands());
        this.width = Math.max(this.width, input.width);
        this.height = Math.max(this.height, input.height);
        if (scriptObjectMirror != null && input.scriptObjectMirror != null) {
            scriptObjectMirror.callMember("extend", input.scriptObjectMirror.get());
        }

        return this;
    }

    @Override
    protected void parse() {
        ScriptObjectMirror commands = scriptObjectMirror.get("commands");
        if (commands != null) {
            int length = commands.size();
            for (int i = 0; i < length; i++) {
                this.commands.add(new Command().parse(commands));
            }
        }
        this.fill = scriptObjectMirror.get("fill");
        this.stroke = scriptObjectMirror.get("stroke");
        this.strokeWidth = scriptObjectMirror.getIntValue("strokeWidth");
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
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

    @Override
    public String toString() {
        return "Path{" +
                "commands=" + commands +
                ", fill='" + fill + '\'' +
                ", stroke='" + stroke + '\'' +
                ", strokeWidth=" + strokeWidth +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
