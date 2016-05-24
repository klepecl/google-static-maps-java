package org.klepecl.gmap;

/**
 * Created by luka on 24.5.2016.
 */
public enum Format {

    PNG, PNG32, GIF, JPG, JPG_BASELINE;

    public String toUrl() {
        return this.name().toLowerCase().replaceAll("_", "-");
    }

}
