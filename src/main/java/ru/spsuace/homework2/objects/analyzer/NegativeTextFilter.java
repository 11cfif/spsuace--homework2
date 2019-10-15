package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextFilter extends SpamFilter implements TextAnalyzer {

    private static final String[] negativeText = {"=(", ":(", ":|"};

    public NegativeTextFilter() {
        super(negativeText);
    }

    @Override
    public FilterType Analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }

        if (super.Analyze(text) == FilterType.SPAM){
            return FilterType.NEGATIVE_TEXT;
        }

        return FilterType.GOOD;
    }
}