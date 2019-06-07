package com.weihq.opentype4j;

import com.weihq.opentype4j.util.SVGUtils;
import org.junit.Test;

import javax.script.ScriptException;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Test Unit for Path
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
public class PathTest {
    @Test
    public void testToSVG() throws IOException, ScriptException {
        Font font = OpenType.parse(TestUtils.assemblyFilePath("Open-Sans-WOFF-1.0.woff"));
        Path path = font.getGlyphs().get(4).getPath();
        ByteArrayInputStream is = new ByteArrayInputStream(path.toSVG().getBytes("utf-8"));
        FileOutputStream fs = new FileOutputStream(TestUtils.assemblyOutFilePath( "test.png"));
        SVGUtils.convertSVGToPng(is, fs);
    }

    @Test
    public void testToSVGFile() throws IOException, ScriptException {
        Font font = OpenType.parse(TestUtils.assemblyFilePath("Open-Sans-WOFF-1.0.woff"));
        Path path = font.getGlyphs().get(4).getPath();
        path.toSVG(TestUtils.assemblyOutFilePath("test.svg"));
    }
}
