package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {

    private final long lengthString;

    TooLongAnalyzer(long lengthString) {
        this.lengthString = lengthString;
    }



    @Override
    public FilterType analyze(String text) {
        if (lengthString < text.length()) {
            return FilterType.TOO_LONG;
        }
        return null;
    }
}
