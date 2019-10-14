package ru.spsuace.homework2.objects.analyzer;

public class CombinationFilter implements TextAnalyzer {
    FilterType filter;
    private String[] badThings;
    private final static String[] badEmotions = {"=(", ":(", ":|"};
    public CombinationFilter(){
        this.filter = FilterType.NEGATIVE_TEXT;
        this.badThings = badEmotions;
    }
    public CombinationFilter(String[] spamWord) {
        this.filter = FilterType.SPAM;
        this.badThings = spamWord;
    }
    @Override
    public FilterType doFilter(String str) {
        for (String thing : badThings) {
            if (str.contains(thing)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
