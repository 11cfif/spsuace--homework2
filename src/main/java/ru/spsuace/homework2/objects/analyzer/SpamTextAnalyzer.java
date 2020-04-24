package ru.spsuace.homework2.objects.analyzer;

/**
 * фильтр для проверки спама текста
 */
public class SpamTextAnalyzer implements TextAnalyzer {
    private final String[] allSpam;

    public SpamTextAnalyzer(String[] spam) {
      this.allSpam = spam;
    }

    @Override
    public boolean checkText(String text) {
        for (String spam : allSpam) {
            if (text.contains(spam)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.SPAM;
    }
}
