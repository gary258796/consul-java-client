package org.common.consul.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author liaoyushao
 */
public class UrlEncodeUtils {

    /**
     * Encode str
     */
    public static String encode(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, StandardCharsets.UTF_8.toString());
    }

}
