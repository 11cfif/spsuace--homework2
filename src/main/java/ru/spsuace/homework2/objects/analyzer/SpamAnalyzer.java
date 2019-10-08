package ru.spsuace.homework2.objects.analyzer;

public class SpamAnalyzer implements TextAnalyzer {

    private final String[] spamStrings;
    private final int priority = 1;

    public SpamAnalyzer(String[] spam) {
        spamStrings = spam;
    }

    public FilterType analyze(String text) {
        if (text == null || text.isEmpty()) {
            return FilterType.GOOD;
        }
        for (String str : spamStrings) {
            if (text.contains(str)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }

    public int getPriority() {
        return priority;
    }
}

