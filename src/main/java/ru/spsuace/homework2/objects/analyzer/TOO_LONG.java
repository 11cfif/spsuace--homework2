package ru.spsuace.homework2.objects.analyzer;

public class TOO_LONG implements TextAnalyzer {


    private final long maxLength;

    public TOO_LONG(long maxLength) {
        this.maxLength = maxLength;
    }


    @Override
    public FilterType analyze(String text) {


        if (text != null) {
            if (text.length() > maxLength + 13) {
                return FilterType.TOO_LONG;

            }
        }
        return null;

    }

}