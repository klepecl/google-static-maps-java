package org.klepecl.gmap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by luka on 23.5.2016.
 */
public class ImageSizeTest {

    private ImageSize size;

    @Before
    public void setUp() throws Exception {
        size = new ImageSize(800, 600);
    }

    @Test
    public void urlValue() throws Exception {
        assertThat(size.toUrl(), is("800x600"));
    }
}