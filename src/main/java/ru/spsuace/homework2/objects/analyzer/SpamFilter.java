package ru.spsuace.homework2.objects.analyzer;


public class SpamFilter implements TextAnalyzer {
    private final String[] spam;
    private boolean negativeCheck = false;

    public void setNegativeCheck(boolean negativeCheck) {
        this.negativeCheck = negativeCheck;
    }

    public SpamFilter(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType Analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }

        for (String spam : spam) {
            if (text.contains(spam)) {
                if (negativeCheck) {
                    return FilterType.NEGATIVE_TEXT;
                } else {
                    return FilterType.SPAM;
                }
            }
        }

        return FilterType.GOOD;
    }
}
