package ru.spsuace.homework2.objects.analyzer;

class TooLongText implements TextAnalyzer {
    private final long maxLength;

    public TooLongText(long maxLength) {

        this.maxLength = maxLength;
    }

    @Override
    public FilterType applyFilter(String text) {
        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
