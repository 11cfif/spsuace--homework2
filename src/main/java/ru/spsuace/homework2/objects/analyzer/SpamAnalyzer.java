package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import static ru.spsuace.homework2.objects.analyzer.LinkAnalyzer.LINKS;
import static ru.spsuace.homework2.objects.analyzer.NegativeTextAnalyzer.NEGATIVE;

public class SpamAnalyzer implements TextAnalyzer {

    private final String[] badSpam;

    SpamAnalyzer(String[] badSpam) {
        this.badSpam = badSpam;
    }

    @Override
    public int priority(FilterType type) {
        if (type == FilterType.SPAM) {
            return 0;
        }
        if (type == FilterType.NEGATIVE_TEXT) {
            return 2;
        }
        if (type == FilterType.LINK) {
            return 3;
        }
        return 4;
    }

    @Override
    public FilterType analyze(String text) {
        for (String i : badSpam) {
            if (text.contains(i)) {
                if (Arrays.equals(badSpam, NEGATIVE)) {
                    return FilterType.NEGATIVE_TEXT;
                }
                if (Arrays.equals(badSpam, LINKS)) {
                    return FilterType.LINK;
                }
                return FilterType.SPAM;
            }
        }
        return null;
    }
}
