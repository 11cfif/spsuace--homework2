package ru.spsuace.homework2.objects.analyzer;

public class TooLong implements TextAnalyzer {

    private final long maxLenght;

    public TooLong(long maxLenght) {
        this.maxLenght = maxLenght;
    }

    @Override
    public FilterType Analyze(String text) {
        if (text.length()>maxLenght || text == null) {
            return  FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }

}
