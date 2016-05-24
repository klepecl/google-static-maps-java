package org.klepecl.gmap;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by luka on 24.5.2016.
 */
public class UrlsTest {

    @Test
    public void softEncode() throws Exception {
        assertThat(Urls.encode("size:tiny|color:red"), is("size:tiny%7Ccolor:red"));
        assertThat(Urls.encode("<tag>"), is("%3Ctag%3E"));
        assertThat(Urls.encode("#hash"), is("%23hash"));
        assertThat(Urls.encode("%percent"), is("%25percent"));
    }
}