package org.klepecl.gmap;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarkerColorTest {

    @Test
    public void rgb() throws Exception {
        assertThat(MarkerColor.rgb(255, 0, 0).toUrl(), is("0xFF0000"));
        assertThat(MarkerColor.rgb(0xc0, 0xa0, 0x80).toUrl(), is("0xC0A080"));
    }

}