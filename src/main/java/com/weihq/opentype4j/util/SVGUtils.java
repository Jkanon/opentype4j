package com.weihq.opentype4j.util;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

import java.io.*;

/**
 * Utilities for svg
 *
 * @author Jkanon
 * @date 2019/06/07
 **/
public class SVGUtils {
    private SVGUtils() {
    }

    private static String CHARSET_STRING_UTF8 = "UTF-8";

    public static String toSVGDomString(String svgPathElement) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" standalone=\"no\"?>\n");
        sb.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
        sb.append("<svg width=\"100%\" height=\"100%\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        sb.append(svgPathElement);
        sb.append("\n</svg>");
        return sb.toString();
    }

    public static void writeToSVG(File file, String svgPathElement)
            throws IOException {
        File dir = file.getParentFile();
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        BufferedWriter writer = null;
        try {
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os, CHARSET_STRING_UTF8);
            writer = new BufferedWriter(osw);
            writer.write(toSVGDomString(svgPathElement));
            writer.flush();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void convertSVGToPng(InputStream in, OutputStream out) {
        try {
            PNGTranscoder t = new PNGTranscoder();
            TranscoderInput input = new TranscoderInput(in);
            TranscoderOutput output = new TranscoderOutput(out);
            t.transcode(input, output);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
            }
        }
    }
}
