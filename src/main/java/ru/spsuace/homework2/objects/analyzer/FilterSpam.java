package ru.spsuace.homework2.objects.analyzer;
public class FilterSpam implements TextAnalyzer {
    protected String[] spamWord;
    public FilterSpam(String[] spamWord) {
        this.spamWord = spamWord;
    }
    @Override
    public FilterType doFilter(String str) {
        for (String word : spamWord) {
            if (str.contains(word)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}