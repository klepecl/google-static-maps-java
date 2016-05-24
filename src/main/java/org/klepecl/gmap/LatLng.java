package org.klepecl.gmap;

import lombok.RequiredArgsConstructor;

import java.util.Locale;

/**
 * Created by luka on 24.5.2016.
 *
 * Location on earth in degrees
 */
@RequiredArgsConstructor
public class LatLng {

    private final double lat;
    private final double lng;

    public String toUrl() {
        return String.format(Locale.ENGLISH, "%.6f,%.6f", lat, lng);
    }
}
