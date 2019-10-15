package ru.spsuace.homework2.objects.analyzer;

public class ToLongAnalyzer implements TextAnalyzer {
    private long maxLength;

    ToLongAnalyzer(long maxLength) {
        this.maxLength = maxLength;
    }


    @Override
    public FilterType analyzeText(String text) {
        int length = 0;
        if (text != null) {
            length = text.length();
        }
        if(length > maxLength){
            return FilterType.TOO_LONG;
        }
        else{
            return FilterType.GOOD;
        }
    }
}
