package ru.spsuace.homework2.objects.analyzer;

public class SPAM implements TextAnalyzer {

    private final String[] spam;

    public SPAM(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType analyze(String text) {
        if (text != null) {
            for (String spam : spam) {

                if (text.contains(spam)) {
                    return FilterType.SPAM;
                }
            }
        }
        return null;
    }

}