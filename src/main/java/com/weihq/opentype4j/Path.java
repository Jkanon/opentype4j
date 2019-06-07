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
public class Path extends AbstractParser<Path> {
    private List<Command> commands = new ArrayList<>();

    private String fill;

    private String stroke;

    private int strokeWidth;

    public String toSVG() {
        String path = toSVGPath();

        return path;
    }

    public String toSVGPath() {
        return (String) scriptObjectMirror.callMember("toSVG");
    }

    @Override
    protected void parse() {
        ScriptObjectMirror commands = fetch("commands");
        if (commands != null) {
            int length = commands.size();
            for (int i = 0; i < length; i++) {
                this.commands.add(new Command().parse(commands));
            }
        }
        this.fill = fetch("fill");
        this.stroke = fetch("stroke");
        this.strokeWidth = fetchIntValue("strokeWidth");
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
}
