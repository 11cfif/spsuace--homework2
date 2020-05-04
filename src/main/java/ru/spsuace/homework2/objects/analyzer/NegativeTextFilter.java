package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextFilter extends SpamFilter {
    private static final String[] NEGATIVE = new String[] { "=(", ":(", ":|" };

    public NegativeTextFilter () {
        super(NEGATIVE);
    }

    @Override
    public FilterType getType() {
        return FilterType.NEGATIVE_TEXT;
    }
}