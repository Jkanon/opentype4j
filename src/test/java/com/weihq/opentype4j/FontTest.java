package com.weihq.opentype4j;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Test Unit for Font
 *
 * @author Jkanon
 * @date 2019/06/08
 **/
public class FontTest {
    private Font font;

    @Test
    public void testGetPath() throws IOException {
        font.getPath().toSVG(TestUtils.assemblyOutFilePath("font-getPath.svg"));
    }

    @Test
    public void testGetPathWithText() throws IOException {
        font.getPath("you are right").toImage(new File(TestUtils.assemblyOutFilePath("font-getPath-with-text.jpg")));
    }

    @Before
    public void initFont() throws IOException {
        font = OpenType.parse(TestUtils.assemblyFilePath("Open-Sans-WOFF-1.0.woff"));
    }
}
