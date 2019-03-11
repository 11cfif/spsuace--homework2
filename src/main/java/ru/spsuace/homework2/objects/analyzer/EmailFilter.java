package ru.spsuace.homework2.objects.analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFilter extends Analyzing {
    private FilterType filter = FilterType.CUSTOM;

    @Override
    public FilterType doFilter(String text) {
        Pattern pattern = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()) {
            return filter;
        }
        return FilterType.GOOD;
    }

    @Override
    public int getFilterNumber() {
        return filter.getNumber();
    }
}
