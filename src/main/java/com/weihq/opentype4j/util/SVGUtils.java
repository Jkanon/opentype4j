package com.weihq.opentype4j.util;

import com.weihq.opentype4j.render.ImageFormat;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.io.IOUtils;

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

    public static void writeToSVG(File file, String svgDomString)
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
            writer.write(svgDomString);
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

    public static void converSVGToImage(InputStream in, OutputStream out, ImageFormat format) {
        try {
            ImageTranscoder transcoder;
            if (format == ImageFormat.JPEG) {
                transcoder = new JPEGTranscoder();
                transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(.8));
            } else {
                transcoder = new PNGTranscoder();
            }
            TranscoderInput input = new TranscoderInput(in);
            TranscoderOutput output = new TranscoderOutput(out);
            transcoder.transcode(input, output);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
}
