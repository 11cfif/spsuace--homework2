package ru.spsuace.homework2.objects.analyzer;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class CustomAnalyzer extends Analyzer {

    // проверка на присутствие мобильного номера (пусть будет Megafon)
    public CustomAnalyzer(FilterType filter) {
        super(filter);
    }

    @Override
    public FilterType analyze(String text) {
        if (!text.matches("\\+7|8?921|931?[0-9]{7}")) {
            return filter;
        }
        return FilterType.GOOD;
    }
}
