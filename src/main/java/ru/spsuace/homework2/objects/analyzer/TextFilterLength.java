package ru.spsuace.homework2.objects.analyzer;

public class TextFilterLength implements TextAnalyzer {
    private final long maxLength;

    public TextFilterLength(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType analyze(String text) {
        if (text == null || text.length() == 0) {


            return FilterType.GOOD;
        }
        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
