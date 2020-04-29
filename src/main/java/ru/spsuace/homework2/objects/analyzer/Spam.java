package ru.spsuace.homework2.objects.analyzer;


public class Spam {

    private final String[] badwords;

    public Spam(String[] spam) {
        this.badwords = spam;
    }

    public FilterType analyze(String text) {
        FilterType result = FilterType.GOOD;
        for (String badword : badwords)
            if (text.contains(badword)) {
                result = FilterType.SPAM;
                break;
            }
        return result;
    }
}