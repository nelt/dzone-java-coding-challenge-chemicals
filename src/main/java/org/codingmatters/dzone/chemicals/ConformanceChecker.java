package org.codingmatters.dzone.chemicals;

/**
 * Created by nelt on 8/9/16.
 */
public class ConformanceChecker {

    public static void main(String[] args) {
        if(args.length != 2) throw new RuntimeException("usage: <element name> <symbol>");

        Conformity conformity = new ConformanceChecker().isConform(args[0], args[1]);
        if(conformity.isConform()) {
            System.out.println(args[1] + " symbol is conform for " + args[0]);
            System.exit(0);
        } else {
            System.err.println(args[1] + " symbol is not conform for " + args[0] + " : " + conformity.getReason());
            System.exit(1);
        }
    }

    public Conformity isConform(String element, String symbol) {
        if(element.length() < 2) throw new IllegalArgumentException("element name must be at least two characters long");

        element = element.toLowerCase();
        symbol = symbol.toLowerCase();

        if(! this.isSymbolTwoLettersLong(symbol)) {
            return Conformity.notConform("symbol is more than 2 characters");
        }

        if(! this.isSymbolLettersInElementName(element, symbol)) {
            return Conformity.notConform("characters' symbols are not in element's name");
        }

        if(this.areLettersProperlyOrdered(element, symbol)) {
            return Conformity.conform();
        } else {
            return Conformity.notConform("symbol's second character must appear after the first one in the element's name");
        }
    }

    private boolean isSymbolTwoLettersLong(String symbol) {
        return symbol.length() == 2;
    }

    private boolean isSymbolLettersInElementName(String element, String symbol) {
        for (char c : symbol.toCharArray()) {
            if(element.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    private boolean areLettersProperlyOrdered(String element, String symbol) {
        boolean lettersProperlyOrdered = true;
        int firstIndex = element.indexOf(symbol.charAt(0));
        String remaining = element.substring(firstIndex + 1);
        int secondIndex = firstIndex + 1 + remaining.indexOf(symbol.charAt(1));

        if(firstIndex >= secondIndex) {
            lettersProperlyOrdered = false;
        }
        return lettersProperlyOrdered;
    }
}
