package ru.spsuace.homework2.objects.analyzer;

public class Spam implements TextAnalyzer{
    private final String[] spam;
   // private FilterType filter;



    public Spam(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType analyzer(String text) {

        for (String s : spam) {
            if (text.contains(s)) {
                return FilterType.SPAM;
            }
        }

        return FilterType.GOOD;
    }
}
