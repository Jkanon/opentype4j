package com.weihq.opentype4j;

import com.weihq.opentype4j.render.FontCell;
import org.junit.Before;
import org.junit.Test;

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
        font.getGlyphs().get(4).getPath().toSVG(TestUtils.assemblyOutFilePath("test.svg"));
    }

    @Test
    public void testExtend() throws IOException {
        FontCell fontCell = new FontCell();
        fontCell.setRelativeX(100);
        font.getGlyphs().get(4).getPath(new FontCell(100, 100)).extend(
                font.getGlyphs().get(5).getPath(fontCell)
        ).toSVG(TestUtils.assemblyOutFilePath("test.svg"));
    }

    @Before
    public void initFont() throws IOException {
        font = OpenType.parse(TestUtils.assemblyFilePath("Open-Sans-WOFF-1.0.woff"));
    }
}
