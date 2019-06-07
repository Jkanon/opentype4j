package com.weihq.opentype4j;

/**
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
public class TestUtils {
    public static final String TEST_PATH = "src/test/files/";

    public static String assemblyFilePath(String fileName) {
        return TEST_PATH + fileName;
    }

    public static String assemblyOutFilePath(String fileName) {
        return TEST_PATH + "/tmp/" + fileName;
    }
}
