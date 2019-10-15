package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer extends SpamAnalyzer {

    private static String[] invalidSymbols = {"=(", ":(", ":|"};

    public NegativeTextAnalyzer() {
        super(invalidSymbols, FilterType.NEGATIVE_TEXT);
    }

}
