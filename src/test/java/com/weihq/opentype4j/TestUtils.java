package com.weihq.opentype4j;

/**
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
class TestUtils {
    static final String TEST_PATH = "src/test/files/";

    static String assemblyFilePath(String fileName) {
        return TEST_PATH + fileName;
    }

    static String assemblyOutFilePath(String fileName) {
        return TEST_PATH + "/tmp/" + fileName;
    }
}
