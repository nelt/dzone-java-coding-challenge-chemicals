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
        assertThat(checker.isConform("Boron", "Bo").getReason(), is(""));
    }

    @Test
    public void lessThanTwoLetters_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "B").isConform(), is(false));
        assertThat(checker.isConform("Boron", "B").getReason(), is("symbol is more than 2 characters"));
    }

    @Test
    public void moreThanTwoLetters_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Bor").isConform(), is(false));
        assertThat(checker.isConform("Boron", "Bor").getReason(), is("symbol is more than 2 characters"));
    }

    @Test
    public void firstLetterNotInElement_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Zo").isConform(), is(false));
        assertThat(checker.isConform("Boron", "Zo").getReason(), is("characters' symbols are not in element's name"));
    }

    @Test
    public void secondLetterNotInElement_NotConform() throws Exception {
        assertThat(checker.isConform("Boron", "Bz").isConform(), is(false));
        assertThat(checker.isConform("Boron", "Bz").getReason(), is("characters' symbols are not in element's name"));
    }

    @Test
    public void symbolCharacterNotInElementOrder_NotConform() throws Exception {
        assertThat(checker.isConform("Silver", "Rv").isConform(), is(false));
        assertThat(checker.isConform("Silver", "Rv").getReason(), is("symbol's second character must appear after the first one in the element's name"));
    }

    @Test
    public void doubleLetterSymbol_letterTwiceInWord_conform() throws Exception {
        assertThat(checker.isConform("Xenon", "Nn").isConform(), is(true));
    }

    @Test
    public void doubleLetterSymbol_letterNotTwiceInWord_notConform() throws Exception {
        assertThat(checker.isConform("Xenon", "Xx").isConform(), is(false));
    }

}