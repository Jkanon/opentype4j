package com.weihq.opentype4j;

import com.weihq.opentype4j.render.FontCell;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;

/**
 * Test Unit for Path
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
public class PathTest {
    private Font font;

    @Test
    public void testToImage() throws IOException {
        font.getGlyphs().get(4).getPath().toImage(new File(TestUtils.assemblyOutFilePath("test.jpg")));
    }

    @Test
    public void testToSVGFile() throws IOException {
        font.getGlyphs().get(4).getPath(new FontCell(100, 100)).toSVG(TestUtils.assemblyOutFilePath("test.svg"));
    }

    @Before
    public void initFont() throws ScriptException, IOException {
        font = OpenType.parse(TestUtils.assemblyFilePath("Open-Sans-WOFF-1.0.woff"));
    }
}
