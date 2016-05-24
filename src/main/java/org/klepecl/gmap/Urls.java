package org.klepecl.gmap;

/**
 * Created by luka on 24.5.2016.
 */
public class Urls {

    public static String encode(String url) {
        return url.replaceAll("%", "%25")
                .replaceAll("\"", "%22")
                .replaceAll("<", "%3C")
                .replaceAll(">", "%3E")
                .replaceAll("#", "%23")
                .replaceAll("\\|", "%7C")
                .replaceAll("\\s+", "+");
    }

}
