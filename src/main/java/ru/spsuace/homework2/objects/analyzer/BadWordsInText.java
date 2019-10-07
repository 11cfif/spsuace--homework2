package ru.spsuace.homework2.objects.analyzer;

class BadWordsInText implements TextAnalyzer {
    private final String[] arrayBadWords;

    public BadWordsInText(String[] arrayBadWords) {

        this.arrayBadWords = arrayBadWords;
    }

    @Override
    public FilterType applyFilter(String text) {
        for (String elementArray : arrayBadWords)
            if (text.contains(elementArray)) {
                return FilterType.SPAM;
            }
        return FilterType.GOOD;
    }
}
