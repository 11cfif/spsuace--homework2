package ru.spsuace.homework2.objects.analyzer;

class BadEmotionsInText extends BadWordsInText {

    public BadEmotionsInText() {
        super(new String [] {"=(", ":(", ":|"});
    }

    @Override
    public FilterType applyFilter(String text) {
        if (super.applyFilter(text) != FilterType.GOOD) {
            return FilterType.NEGATIVE_TEXT;
        }
        return FilterType.GOOD;
    }

}
