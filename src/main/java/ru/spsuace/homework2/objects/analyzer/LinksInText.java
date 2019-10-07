package ru.spsuace.homework2.objects.analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LinksInText implements TextAnalyzer {
    final String regexLink = "(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";


    final Pattern pattern = Pattern.compile(regexLink);

    @Override
    public FilterType applyFilter(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }
}
