package org.codingmatters.dzone.chemicals;

import java.util.Arrays;

/**
 * Created by nelt on 8/11/16.
 */
public class SymbolFinder {

    public String firstSymbolFor(String element) {
        element = element.toLowerCase();

        char first = this.findFirst(element);
        char second = this.findSecond(element, first);

        return new String(new char[] {Character.toUpperCase(first), second});
    }

    private char findFirst(String element) {
        char[] ordered = element.substring(0, element.length() - 1).toCharArray();
        Arrays.sort(ordered);
        return ordered[0];
    }

    private char findSecond(String element, char first) {
        int firstIndex = element.indexOf(first);
        String afterFirst = element.substring(firstIndex + 1);

        char[] ordered = afterFirst.toCharArray();
        Arrays.sort(ordered);

        return ordered[0];
    }
}
