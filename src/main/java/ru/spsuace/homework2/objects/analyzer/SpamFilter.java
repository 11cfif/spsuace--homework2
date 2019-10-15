package ru.spsuace.homework2.objects.analyzer;

public class SpamFilter extends Analyzer {

    private final String[] spam;

    public SpamFilter(String[] spam, FilterType filter) {
        super(filter);
        this.spam = spam;
    }

    public FilterType analyze(String text) {
        for (int i = 0; i < spam.length; i++) {
            if (text.contains(spam[i])){
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
