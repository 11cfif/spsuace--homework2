package ru.spsuace.homework2.objects.analyzer;

class LengthFilter implements TextAnalyzer {
    private final long maxLength;

    LengthFilter(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType doFilter(String str) {
        if (str.length() > maxLength) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}