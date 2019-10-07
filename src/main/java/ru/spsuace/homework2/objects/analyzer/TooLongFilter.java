package ru.spsuace.homework2.objects.analyzer;


public class TooLongFilter implements TextAnalyzer{
    private long length;
    public TooLongFilter(long length) {
        this.length = length;
    }

    @Override
    public FilterType startFilter(String text) {
        if (text.length() > length){
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
