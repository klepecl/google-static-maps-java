package org.klepecl.gmap;

/**
 * Created by luka on 24.5.2016.
 */
public enum MarkerSize {
    TINY, MID, SMALL;

    public String toUrl() {
        return name().toLowerCase();
    }
}
