package ru.spsuace.homework2.objects.analyzer;

public class Custom implements TextAnalyzer{
    public final String[] customtxt = {"?","!"};
    @Override
    public FilterType analyzer(String text) {
        for (String c : customtxt) {
            if (text.contains(c)) {
                return FilterType.CUSTOM;
            }
        }

        return FilterType.GOOD;
    }
}
