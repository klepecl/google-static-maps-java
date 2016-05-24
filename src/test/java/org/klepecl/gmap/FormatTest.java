package org.klepecl.gmap;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FormatTest {

    @Test
    public void testUrlValues() {
        assertThat(Format.GIF.toUrl(), is("gif"));
        assertThat(Format.PNG.toUrl(), is("png"));
        assertThat(Format.PNG32.toUrl(), is("png32"));
        assertThat(Format.JPG.toUrl(), is("jpg"));
        assertThat(Format.JPG_BASELINE.toUrl(), is("jpg-baseline"));
    }

}