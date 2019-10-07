package ru.spsuace.homework2.objects.analyzer;

class BadEmotionsInText implements TextAnalyzer {
    private final String[] arrayBadEmotions = {"=(", ":(", ":|"};


    @Override
    public FilterType applyFilter(String text) {
        for (String elementArray : arrayBadEmotions) {
            if (text.contains(elementArray)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}
