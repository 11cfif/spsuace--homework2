package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {

    private final long lengthString;

    TooLongAnalyzer(long lengthString) {
        this.lengthString = lengthString;
    }

    @Override
    public boolean check(String text) {
        if (lengthString < text.length()) {
            return true;
        }
        return false;
    }

    @Override
    public FilterType getFilter() {
        return FilterType.TOO_LONG;
    }
}
