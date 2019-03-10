package ru.spsuace.homework2.objects.analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterCustom implements TextAnalyzer {
    private String pat = "(.*)(\\d+)(.*)";
    private Pattern pattern = Pattern.compile(pat);


    @Override
    public FilterType analyzeText(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }

    @Override
    public int getId() {
        return FilterType.GOOD.getNumber();
    }
}
