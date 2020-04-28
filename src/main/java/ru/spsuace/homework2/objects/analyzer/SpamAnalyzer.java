package ru.spsuace.homework2.objects.analyzer;

import java.io.StringReader;

public class SpamAnalyzer implements TextAnalyzer {

    private final String[] badwords;

    public SpamAnalyzer(String[] spam) {
        this.badwords = spam;
    }

    @Override
    public FilterType analyze(String text) {
        FilterType result = FilterType.GOOD;
        for (String badword : badwords)
            if (text.contains(badword)) {
                result = FilterType.SPAM;
                break;
            }
        return result;
    }
}
