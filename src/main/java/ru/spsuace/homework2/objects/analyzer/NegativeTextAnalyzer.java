package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer implements TextAnalyzer {
    private final String[] emojis = {"=(",":(",":|"};

    @Override
    public FilterType analyze(String text){
        FilterType result =FilterType.GOOD;
        for(String emoji : emojis)
            if (text.contains(emoji)) {
                result = FilterType.NEGATIVE_TEXT;
                break;
            }
        return result;
    }
}
