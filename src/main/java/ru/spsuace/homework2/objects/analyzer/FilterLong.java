package ru.spsuace.homework2.objects.analyzer;

public class FilterLong implements TextAnalyzer {

    private long maxLength;

    FilterLong(long length){

        maxLength = length;
    }

    public FilterType textAnalyzer(String text) {

        if (text.length() > maxLength ){
            return FilterType.TOO_LONG;
        }

        return FilterType.GOOD;
    }
}
