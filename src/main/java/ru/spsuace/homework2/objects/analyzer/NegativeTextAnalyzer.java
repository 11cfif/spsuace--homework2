package ru.spsuace.homework2.objects.analyzer;

/**
 * фильтр для проверки плохих эмоций в тексте
 */
public class NegativeTextAnalyzer extends SpamTextAnalyzer {
    private static final String[] NEGATIVE_EMOJI = new String[] { "=(", ":(", ":|" };

    public NegativeTextAnalyzer () {
        super(NEGATIVE_EMOJI);
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.NEGATIVE_TEXT;
    }
}
