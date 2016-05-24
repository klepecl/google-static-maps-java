package org.klepecl.gmap;

import com.google.common.base.Preconditions;
import lombok.Builder;

import java.util.Optional;

@Builder
public class MarkerStyles {

    private MarkerSize size;
    private MarkerColor color;
    private Character label;

    public String toUrl() {
        UrlBuilder ub = new UrlBuilder();
        Optional.ofNullable(size).ifPresent(ub::size);
        Optional.ofNullable(color).ifPresent(ub::color);
        Optional.ofNullable(label).ifPresent(ub::label);
        return ub.build();
    }

    private static class UrlBuilder {
        private final StringBuilder sb = new StringBuilder();

        public String build() {
            return sb.toString();
        }

        public void size(MarkerSize size) {
            next();
            sb.append("size:").append(size.toUrl());
        }

        public void color(MarkerColor color) {
            next();
            sb.append("color:").append(color.toUrl());
        }

        public void label(Character label) {
            next();
            Preconditions.checkState((label >= 'A' && label <= 'Z') || (label >= '0' && label <= '9'));
            sb.append("label:").append(label);
        }

        private void next() {
            if (sb.length() > 0)
                sb.append('|');
        }
    }
}
