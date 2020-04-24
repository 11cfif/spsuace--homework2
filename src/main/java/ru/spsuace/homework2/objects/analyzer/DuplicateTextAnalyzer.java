package ru.spsuace.homework2.objects.analyzer;

/**
 * фильтр для проверки повторов слов в тексте
 */
public class DuplicateTextAnalyzer implements TextAnalyzer {
    private final TextToMaxCountPair textToMaxCountPair;

    public DuplicateTextAnalyzer(TextToMaxCountPair textToMaxCountPair) {
        this.textToMaxCountPair = textToMaxCountPair;
    }

    @Override
    public boolean checkText(String text) {
        if (textToMaxCountPair == null || textToMaxCountPair.getText() == null || textToMaxCountPair.getMaxCount() < 0 ||
                text.length() < textToMaxCountPair.getText().length()) {
            return false;
        }

        int count = 0;
        String copyText = text;

        while (!copyText.isEmpty() && copyText.contains(textToMaxCountPair.getText())) {
            copyText = copyText.replaceFirst(textToMaxCountPair.getText(), "");
            count++;
        }

        return count > textToMaxCountPair.getMaxCount();
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.DUPLICATE;
    }
}
