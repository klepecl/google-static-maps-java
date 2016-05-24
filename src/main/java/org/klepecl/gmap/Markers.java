package org.klepecl.gmap;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Singular;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Collection of markers with same style
 */
@Builder
public class Markers {

    private MarkerStyles styles;
    private @Singular List<MarkerLocation> locations;

    public String toUrl() {
        Preconditions.checkState(!locations.isEmpty(), "Empty location");
        String url = Optional.ofNullable(styles).map(MarkerStyles::toUrl).map(styles -> styles + "|").orElse("")
                + locations.stream().map(MarkerLocation::toUrl).collect(Collectors.joining("|"));

        return Urls.encode(url);
    }
}
