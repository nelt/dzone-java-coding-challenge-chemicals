package org.codingmatters.dzone.chemicals;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by nelt on 8/9/16.
 */
public class ConformanceCheckerTest {

    private ConformanceChecker checker = new ConformanceChecker();

    @Test
    public void conform() throws Exception {
        assertThat(checker.isConform("Boron", "Bo").isConform(), is(true));
    }

    @Test
    public void lessThanTwoLetters_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "B").isConform(), is(false));
    }

    @Test
    public void moreThanTwoLetters_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Bor").isConform(), is(false));
    }

    @Test
    public void firstLetterNotInElement_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Zo").isConform(), is(false));
    }

    @Test
    public void secondLetterNotInElement_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Bz").isConform(), is(false));
    }

    @Test
    public void symbolCharacterNotInElementOrder_NotConform() throws Exception {
        assertThat(checker.isConform("Silver", "Rv").isConform(), is(false));
    }

}