package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer extends SpamAnalyzer {

    final static String[] NEGATIVE = {"=(", ":(", ":|"};

    public NegativeTextAnalyzer() {
        super(NEGATIVE);
    }

    @Override
    public int priority(FilterType type) {
        if (type == FilterType.NEGATIVE_TEXT) {
            return 2;
        }
        return 4;
    }
}