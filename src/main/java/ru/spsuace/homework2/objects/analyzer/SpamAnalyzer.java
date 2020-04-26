package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;

import static ru.spsuace.homework2.objects.analyzer.NegativeTextAnalyzer.NEGATIVE;

public class SpamAnalyzer implements TextAnalyzer {

    private final String[] badSpam;

    SpamAnalyzer(String[] badSpam) {
        this.badSpam = badSpam;
    }

    @Override
    public FilterType analyze(String text) {
        for (String i : badSpam) {
            if (text.contains(i)) {
                if (Arrays.equals(badSpam,NEGATIVE)){
                    return FilterType.NEGATIVE_TEXT;
                }
                return FilterType.SPAM;
            }
        }
        return null;
    }
}
