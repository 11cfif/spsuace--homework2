package ru.spsuace.homework2.objects.analyzer;


public class Spam  {
    private String[] spam;

    Spam(String[] spam) {
        this.spam = spam;
    }


    public FilterType textAnalyzer(String text) {
        for (String bad : spam) {
            if (text.contains(bad)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;

    }
}