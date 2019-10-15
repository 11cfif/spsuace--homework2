package ru.spsuace.homework2.objects.analyzer;

public class NegativeAnalyzer implements TextAnalyzer {

    private final String[] negatives = {"=(", ":(", ":|"};

    @Override
    public FilterType analyzeText(String text) {
        for(String negative: negatives){
            if(text.contains(negative)){
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}
