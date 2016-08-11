package org.codingmatters.dzone.chemicals;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nelt on 8/11/16.
 */
public class ConformanceCheckerAcceptanceTest {

    private ConformanceChecker checker = new ConformanceChecker();

    @Test
    public void Splengerium_Ee_conform() throws Exception {
        assertThat(checker.isConform("Splengerium", "Ee").isConform(), is(true));
    }

    @Test
    public void Zeddemorium_Zr_conform() throws Exception {
        assertThat(checker.isConform("Zeddemorium", "Zr").isConform(), is(true));
    }

    @Test
    public void Venkmine_Kn_conform() throws Exception {
        assertThat(checker.isConform("Venkmine", "Kn").isConform(), is(true));
    }

    @Test
    public void Stantzon_Zt_notConform() throws Exception {
        assertThat(checker.isConform("Stantzon", "Zt").isConform(), is(false));
    }

    @Test
    public void Melitzum_Nn_notConform() throws Exception {
        assertThat(checker.isConform("Melintzum", "Nn").isConform(), is(false));
    }

    @Test
    public void Tullium_Ty_notConform() throws Exception {
        assertThat(checker.isConform("Tullium", "Ty").isConform(), is(false));
    }
}
