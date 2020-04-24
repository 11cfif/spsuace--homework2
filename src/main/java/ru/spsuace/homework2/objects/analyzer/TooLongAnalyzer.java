package ru.spsuace.homework2.objects.analyzer;

class ToLongAnalyzer implements TextAnalyzer {

    private long lengthString;

    ToLongAnalyzer(long lengthString) {
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
