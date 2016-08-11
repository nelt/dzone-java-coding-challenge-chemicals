package org.codingmatters.dzone.chemicals;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nelt on 8/11/16.
 */
public class SymbolFinderTest {

    private SymbolFinder finder = new SymbolFinder();

    @Test
    public void symbolForGozerium_Ei() throws Exception {
        assertThat(finder.firstSymbolFor("Gozerium"), Matchers.is("Ei"));
    }

    @Test
    public void symbolForSlimyrine_Ie() throws Exception {
        assertThat(finder.firstSymbolFor("Slimyrine"), Matchers.is("Ie"));
    }
}