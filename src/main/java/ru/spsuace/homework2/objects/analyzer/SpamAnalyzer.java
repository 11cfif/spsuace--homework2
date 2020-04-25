package ru.spsuace.homework2.objects.analyzer;

public interface SpamAnalyzer extends TextAnalyzer {

    private final String[] keywords;

    public SpamAnalyzer(String[] spam) {
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
