package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class FilterSpam extends StringTextAnalyze implements TextAnalyzer {
    private final FilterType filter = FilterType.SPAM;
    private Collection<String> spam;

    public FilterSpam(Collection<String> spam) {
        this.spam = spam;
    }


    @Override
    public FilterType analyzeText(String text) {
        return analyzeTextString(text, filter, spam);
    }
}
