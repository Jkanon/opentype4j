package com.weihq.opentype4j;

import org.junit.Test;

/**
 * Test Unit for OpenType
 *
 * @author Jkanon
 * @date 2019/06/06
 **/
public class OpenTypeTest {
    public static final String TEST_PATH = "src/test/files/";

    @Test
    public void testParse() throws Exception {
        Font font = OpenType.parse(TEST_PATH + "Open-Sans-WOFF-1.0.woff");
        System.out.println(font.getGlyphs().get(2).getPath().toSVG());
    }
}
