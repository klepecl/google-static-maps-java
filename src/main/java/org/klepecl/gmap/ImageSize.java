package org.klepecl.gmap;

import java.util.Locale;

/**
 * ImageSize of returned image
 */
public class ImageSize {

    private final int height;
    private final int width;

    public ImageSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toUrl() {
        return String.format(Locale.ENGLISH, "%dx%d", width, height);
    }
}
