package ru.spsuace.homework2.objects.analyzer;

public class TooLong extends Analyzer {

    private final long LENGTH;

    public TooLong(long length) {
        super(FilterType.TOO_LONG);
        LENGTH = length;
    }

    @Override
    public boolean checkFilter(String Text) {
        return Text.length() > LENGTH;
    }
}