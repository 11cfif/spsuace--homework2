package ru.spsuace.homework2.objects.analyzer;

public class SpamAnalyzer implements TextAnalyzer {

    private final String[] keywords;

    public SpamAnalyzer(String[] spam) {
        this.keywords = spam;
    }

    @Override
    public boolean checkFilter(String text) {
        for (String keyword : keywords)
            if (text.contains(keyword)) {
                return true;
            }
        return false;
    }

    @Override
    public FilterType getFilter() {
        return FilterType.SPAM;
    }
}