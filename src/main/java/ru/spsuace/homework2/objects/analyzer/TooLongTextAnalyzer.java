package ru.spsuace.homework2.objects.analyzer;

/**
 * фильтр для проверки на слишком длинный текст
 */
public class TooLongTextAnalyzer implements TextAnalyzer {
    private final long maxLength;

    public TooLongTextAnalyzer (long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean checkText(String text) {
        return text.length() > maxLength;
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.TOO_LONG;
    }
}
