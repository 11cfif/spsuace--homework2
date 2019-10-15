package ru.spsuace.homework2.objects.analyzer;

public class LengthFilter implements TextAnalyzer {
    private final long maxLength;

   public LengthFilter(long maxLength) {
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