package ru.spsuace.homework2.objects.analyzer;

public class Spam extends Negative {

    private final String[] keywords;

    public Spam(String[] spam) {
        this.keywords = spam;
    }

    @Override
    public FilterType analyze(String text) {
        FilterType result = FilterType.GOOD;
        for (String keyword : keywords)
            if (text.contains(keyword)) {
                result = FilterType.SPAM;
                break;
            }
        return result;
    }
}