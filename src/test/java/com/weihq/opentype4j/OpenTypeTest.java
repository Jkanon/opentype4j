package com.weihq.opentype4j;

import org.junit.Test;

/**
 * Test Unit for OpenType
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class OpenTypeTest {
    @Test
    public void testParse() throws Exception {
        Font font = OpenType.parse(TestUtils.assemblyFilePath("Open-Sans-WOFF-1.0.woff"));
        System.out.println(font.nameToGlyph("one").getPath().toSVG());
    }
}
