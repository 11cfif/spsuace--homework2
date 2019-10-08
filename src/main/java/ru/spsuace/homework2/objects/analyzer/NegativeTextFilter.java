package ru.spsuace.homework2.objects.analyzer;


public class NegativeTextFilter extends SpamFilter {
    private final static String[] badEmotions = {"=(", ":(", ":|"};

    public NegativeTextFilter() {
        super(badEmotions, FilterType.NEGATIVE_TEXT);
    }
}
