package ru.spsuace.homework2.objects.analyzer;

public class Spam extends Analyzer {

    private final String[] SPAM;

    public Spam(String[] spam) {
        super(FilterType.SPAM);
        SPAM = spam;
    }

    public Spam(String[] spam, FilterType type) {
        super(type);
        SPAM = spam;
    }

    @Override
    public boolean checkFilter(String Text) {
        for (String evil : SPAM) {
            if (Text.contains(evil)) {
                return true;
            }
        }
        return false;
    }
}