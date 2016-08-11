package org.codingmatters.dzone.chemicals;

import java.util.Arrays;

/**
 * Created by nelt on 8/11/16.
 */
public class SymbolFinder {

    public String firstSymbolFor(String element) {
        StringBuilder result = new StringBuilder();

        char[] ordered = element.substring(0, element.length() - 1).toUpperCase().toCharArray();
        Arrays.sort(ordered);
        char first = ordered[0];
        int firstIndex = element.toUpperCase().indexOf(first);

        String afterFirst = element.substring(firstIndex + 1);
        ordered = afterFirst.toLowerCase().toCharArray();
        Arrays.sort(ordered);

        System.out.println(new String(ordered));

        char second = ordered[0];
        return result.append(first).append(second).toString();
    }
}
