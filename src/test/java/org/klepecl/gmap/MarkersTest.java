package org.klepecl.gmap;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarkersTest {

    @Test
    public void testLocation() {
        Markers markers = Markers.builder()
                .location(MarkerLocation.at(new LatLng(46.0, 13.0)))
                .build();

        assertThat(markers.toUrl(), is("46.000000,13.000000"));
    }

    @Test
    public void testAddress() {
        Markers markers = Markers.builder()
                .location(MarkerLocation.at("Ulica bratov Mravljakov 7,Velenje"))
                .build();

        assertThat(markers.toUrl(), is("Ulica+bratov+Mravljakov+7,Velenje"));
    }

    @Test
    public void testFull() {
        Markers markers = Markers.builder()
                .location(MarkerLocation.at(new LatLng(46.0, 13.0)))
                .location(MarkerLocation.at(new LatLng(45.0, 13.0)))
                .location(MarkerLocation.at("Ulica bratov Mravljakov 7,Velenje"))
                .styles(MarkerStyles.builder()
                        .size(MarkerSize.TINY)
                        .color(MarkerColor.BLACK)
                        .label('A')
                        .build())
                .build();

        assertThat(markers.toUrl(), is("size:tiny%7Ccolor:black%7Clabel:A%7C46.000000,13.000000%7C45.000000,13.000000%7CUlica+bratov+Mravljakov+7,Velenje"));
    }

}