package ru.spsuace.homework2.objects.analyzer;

public class FilterSpam implements TextAnalyzer {
    protected String[] badWords; //модификатор видимости
    protected FilterType wordFilter;

    public FilterSpam(String[] badWords) { //название совпадает с названием класса//название параметра совпадает с названием поля/ параметры
        this.badWords = badWords;
        wordFilter = FilterType.SPAM;
    }

    protected FilterSpam(String[] badWords, FilterType wordFilter) {
        this(badWords);
        this.wordFilter = wordFilter;/*я не знаю как это исправить, даже в интернете нет по этому поводу нормальной информации*/
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
