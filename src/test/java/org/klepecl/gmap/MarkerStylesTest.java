package org.klepecl.gmap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by luka on 24.5.2016.
 */
public class MarkerStylesTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void textSizeUrl() throws Exception {
        assertThat(MarkerStyles.builder().size(MarkerSize.SMALL).build().toUrl(), is("size:small"));
    }

    @Test
    public void testColorUrl() throws Exception {
        assertThat(MarkerStyles.builder().color(MarkerColor.BLACK).build().toUrl(), is("color:black"));
        assertThat(MarkerStyles.builder().color(MarkerColor.rgb(255, 128, 128)).build().toUrl(), is("color:0xFF8080"));
    }

    @Test
    public void testLabelUrl() throws Exception {
        assertThat(MarkerStyles.builder().label('A').build().toUrl(), is("label:A"));
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalLabelUrl() throws Exception {
        MarkerStyles.builder().label('?').build().toUrl();
    }

    @Test
    public void testUrl() {
        assertThat(MarkerStyles.builder()
                .color(MarkerColor.BLACK)
                .size(MarkerSize.TINY)
                .label('A')
                .build().toUrl(), is("size:tiny|color:black|label:A"));
    }
}