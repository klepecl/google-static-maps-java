package org.klepecl.gmap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Location of a marker
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MarkerLocation {

    public static MarkerLocation at(String address) {
        return new MarkerLocation(null, address);
    }

    public static MarkerLocation at(LatLng latlng) {
        return new MarkerLocation(latlng, null);
    }

    public static MarkerLocation at(double lat, double lng) {
        return MarkerLocation.at(new LatLng(lat, lng));
    }

    private LatLng location;
    private String address;

    public String toUrl() {
        if (location != null) {
            return location.toUrl();
        }
        else {
            return address;
        }
    }
}
