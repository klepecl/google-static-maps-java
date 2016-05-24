package org.klepecl.gmap;

/**
 * maptype
 */
public enum MapType {

    ROADMAP, STAELLITE, TERRAIN, HYBRID;

    public String toUrl() {
        return name().toLowerCase();
    }
}
