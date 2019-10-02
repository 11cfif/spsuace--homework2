package ru.spsuace.homework2.objects.analyzer;

public class FilterSpam implements TextAnalyzer {
    protected String[] badWords; //модификатор видимости
    protected FilterType wordFilter;

    public  FilterSpam(String[] badWords) { //название совпадает с названием класса
        this.badWords = badWords; //название параметра совпадает с названием поля/ параметры
        wordFilter = FilterType.SPAM;
    }

    public  FilterSpam(String[] badWords, FilterType wordFilter) {
        this.badWords = badWords;
        this.wordFilter = wordFilter;
    }

    public FilterSpam(String s, String s1, String s2) {
    }

    public FilterType textAnalyzer(String text) {
        for (String word : badWords) {
            if (text.contains(word)) {
                return wordFilter;
            }
        }
        return FilterType.GOOD;
    }
}
