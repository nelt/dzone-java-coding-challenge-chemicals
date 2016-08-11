package org.codingmatters.dzone.chemicals;

/**
 * Created by nelt on 8/9/16.
 */
public class ConformanceChecker {

    public Conformity isConform(String element, String symbol) {
        element = element.toLowerCase();
        symbol = symbol.toLowerCase();

        if(symbol.length() != 2) {
            return Conformity.notConform("symbol is more than 2 characters");
        }

        for (char c : symbol.toCharArray()) {
            if(element.indexOf(c) == -1) {
                return Conformity.notConform("characters' symbols are not in element's name");
            }
        }

        int firstIndex = element.indexOf(symbol.charAt(0));
        String remaining = element.substring(firstIndex + 1);
        int secondIndex = firstIndex + 1 + remaining.indexOf(symbol.charAt(1));

        if(firstIndex >= secondIndex) {
            return Conformity.notConform("symbol's second character must appear after the first one in the element's name");
        }

        return Conformity.conform();
    }
}
