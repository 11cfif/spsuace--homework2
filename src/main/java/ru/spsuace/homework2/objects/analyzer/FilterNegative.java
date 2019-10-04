package ru.spsuace.homework2.objects.analyzer;

public class FilterNegative extends FilterSpam {
    private final  static String[] BAD_EMOTIONS = {"=(", ":(", ":|"};

    public FilterNegative() {
        super(BAD_EMOTIONS, FilterType.NEGATIVE_TEXT);
    }
}
