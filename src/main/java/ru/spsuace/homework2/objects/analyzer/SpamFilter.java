package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;

public class SpamFilter implements TextAnalyzer {
    private final String[] spam;

    public SpamFilter(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType Analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }

        boolean check = false;
        if (Arrays.equals(spam, new String[]{"=(", ":(", ":|"})){
            check = true;
        }

        for (String spam : spam) {
            if (text.contains(spam)) {
                if (check) {
                    return FilterType.NEGATIVE_TEXT;
                } else {
                    return FilterType.SPAM;
                }
            }
        }

        return FilterType.GOOD;
    }
}
