package org.klepecl.gmap;

import lombok.Builder;

/**
 * Created by luka on 23.5.2016.
 */
@Builder
public class MapsApi {

    private static final String MAPS = "https://maps.googleapis.com/maps/api/staticmap";

    private String key;


    /**
     * Full URL for the request
     *
     * @param request request
     * @return encoded url
     */
    public String url(MapsRequest request) {
        StringBuilder url = new StringBuilder();
        url.append(MAPS);
        url.append(request.url());
        if (key != null) {
            url.append("&key=").append(key);
        }

        if (url.length() > 2048)
            throw new IllegalStateException("Url max length is 2048");

        return url.toString();
    }


    public static void main(String[] args) {
        MapsApi api = new MapsApi(null);

        MapsRequest request = MapsRequest.builder()
                .size(new ImageSize(640, 400))
                .scale(2)
                .zoom(11)
                .center(new LatLng(46.3, 14.8))
                .markers(Markers.builder()
                        .styles(MarkerStyles.builder().color(MarkerColor.BLUE).size(MarkerSize.SMALL).build())
                        .location(MarkerLocation.at(46.35, 14.85))
                        .location(MarkerLocation.at(46.35, 14.75))
                        .location(MarkerLocation.at(46.31, 14.82))
                        .location(MarkerLocation.at(46.28, 14.84))
                        .build())
                .markers(Markers.builder()
                        .styles(MarkerStyles.builder().color(MarkerColor.RED).size(MarkerSize.MID).build())
                        .location(MarkerLocation.at(46.3, 14.8))
                        .build())
                .format(Format.JPG)
                .maptype(MapType.ROADMAP)
                .build();

        System.out.println(api.url(request));
    }
}
