package ru.spsuace.homework2.objects.analyzer;

public class TooLongFilter implements TextAnalyzer {
    private long masLenght;

    public TooLongFilter(long masLenght) {
        this.masLenght = masLenght;
    }

    @Override
    public FilterType doFilter(String text) {

        if (text.length() > masLenght){
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }

}
