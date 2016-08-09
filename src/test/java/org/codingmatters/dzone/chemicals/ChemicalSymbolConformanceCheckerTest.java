package org.codingmatters.dzone.chemicals;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by nelt on 8/9/16.
 */
public class ChemicalSymbolConformanceCheckerTest {

    private ChemicalSymbolConformanceChecker checker = new ChemicalSymbolConformanceChecker();

    @Test
    public void conform() throws Exception {
        assertThat(checker.isConform("Boron", "Bo"), is(true));
    }

    @Test
    public void lessThanTwoLetters_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "B"), is(false));
    }

    @Test
    public void moreThanTwoLetters_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Bor"), is(false));
    }

    @Test
    public void firstLetterNotInElement_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Zo"), is(false));
    }

    @Test
    public void secondLetterNotInElement_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Bz"), is(false));
    }

    @Test
    public void symbolCharacterNotInElementOrder_NotConform() throws Exception {
        assertThat(checker.isConform("Silver", "Rv"), is(false));
    }

}