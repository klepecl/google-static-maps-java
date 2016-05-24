package org.klepecl.gmap;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Singular;

import java.util.Optional;
import java.util.Set;

/**
 * A request to static maps api
 */
@Builder
public class MapsRequest {

    private ImageSize size;
    private LatLng center;
    private int zoom;
    private Integer scale;
    private Format format;
    private MapType maptype;
    // TODO styles
    private @Singular("markers") Set<Markers> markers;

    public String url() {
        UrlBuilder ub = new UrlBuilder();
        ub.size(size);
        ub.zoom(zoom);

        Optional.ofNullable(center).ifPresent(ub::center);
        Optional.ofNullable(scale).ifPresent(ub::scale);
        Optional.ofNullable(format).ifPresent(ub::format);
        Optional.ofNullable(maptype).ifPresent(ub::maptype);

        markers.forEach(ub::markers);

        return ub.build();
    }

    private static class UrlBuilder {

        private final StringBuilder sb = new StringBuilder();

        void size(ImageSize size) {
            Preconditions.checkState(size != null, "ImageSize is required");
            next();
            sb.append("size=").append(size.toUrl());
        }

        void zoom(int zoom) {
            Preconditions.checkState(zoom > 0);
            next();
            sb.append("zoom=").append(zoom);
        }

        void center(LatLng center) {
            next();
            sb.append("center=").append(center.toUrl());
        }

        void scale(Integer scale) {
            Preconditions.checkArgument(scale == 1 || scale == 2 || scale == 4);
            next();
            sb.append("scale=").append(scale.intValue());
        }

        void format(Format format) {
            next();
            sb.append("format=").append(format.toUrl());
        }

        void maptype(MapType maptype) {
            next();
            sb.append("maptype=").append(maptype.toUrl());
        }

        void markers(Markers markers) {
            next();
            sb.append("markers=").append(markers.toUrl());
        }

        /**
         * Prepare string builder for next URL parameter
         */
        private void next() {
            if (sb.length() == 0)
                sb.append('?');
            else
                sb.append('&');
        }

        String build() {
            return sb.toString();
        }

    }
}
