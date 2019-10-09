package ru.spsuace.homework2.objects.analyzer;

import java.util.logging.Filter;

public class SpamAnalyzer extends Analyzer {

    private String[] spamStrings;

    public SpamAnalyzer(String[] spam, FilterType filter) {
        super(filter);
        spamStrings = spam;
    }

    public FilterType analyze(String text) {
        for(String str : spamStrings) {
            if (text.contains(str)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}

