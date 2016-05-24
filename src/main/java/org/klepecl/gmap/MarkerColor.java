package org.klepecl.gmap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by luka on 24.5.2016.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MarkerColor implements Serializable {

    public static final MarkerColor BLACK = new MarkerColor("black");
    public static final MarkerColor BROWN = new MarkerColor("brown");
    public static final MarkerColor GREEN = new MarkerColor("green");
    public static final MarkerColor PURPLE = new MarkerColor("purple");
    public static final MarkerColor YELLOW = new MarkerColor("yellow");
    public static final MarkerColor BLUE = new MarkerColor("blue");
    public static final MarkerColor GRAY = new MarkerColor("gray");
    public static final MarkerColor ORANGE = new MarkerColor("orange");
    public static final MarkerColor RED = new MarkerColor("red");
    public static final MarkerColor WHITE = new MarkerColor("white");

    public static MarkerColor rgb(int r, int g, int b) {
        return new MarkerColor(String.format(Locale.ENGLISH, "0x%02X%02X%02X", r & 0xff, g & 0xff, b & 0xff));
    }


    /** hex or name */
    private String color;

    public String toUrl() {
        return color;
    }
}
