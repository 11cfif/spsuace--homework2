package ru.spsuace.homework2.objects.analyzer;

public class SpamAnalyzer implements TextAnalyzer {
    private String[] spamWords;

    SpamAnalyzer(String[] spamWords) {
        this.spamWords = spamWords;
    }

    @Override
    public FilterType analyzeText(String text) {
        for (String word : spamWords) {
            if (text.contains(word)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
