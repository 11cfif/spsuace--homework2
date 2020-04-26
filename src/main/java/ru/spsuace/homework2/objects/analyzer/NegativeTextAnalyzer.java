package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer extends SpamAnalyzer {

    final static String[] NEGATIVE = {"=(", ":(", ":|"};

    public NegativeTextAnalyzer() {
        super(NEGATIVE);
    }
}