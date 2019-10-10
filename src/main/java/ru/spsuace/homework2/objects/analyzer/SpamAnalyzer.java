package ru.spsuace.homework2.objects.analyzer;

import java.util.logging.Filter;

public class SpamAnalyzer extends Analyzer {

    private final String[] spamText;

    public SpamAnalyzer(String[] spam, FilterType filter) {
        super(filter);
        spamText = spam;
    }

    public FilterType analyze(String text) {
        for (String str : spamText) {
            if (text.contains(str)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
