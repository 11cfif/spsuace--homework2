package ru.spsuace.homework2.objects.analyzer;

class BadEmotionsInText extends BadWordsInText {

    public BadEmotionsInText() {
        super(new String [] {"=(", ":(", ":|"});
    }

    public FilterType applyFilter(String text) {
        if (super.applyFilter(text) == FilterType.SPAM) {
            return FilterType.NEGATIVE_TEXT;
        }
        return FilterType.GOOD;
    }

}
