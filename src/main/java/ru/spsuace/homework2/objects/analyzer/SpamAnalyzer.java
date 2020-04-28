package ru.spsuace.homework2.objects.analyzer;

public class SpamAnalyzer implements TextAnalyzer {

    private final String[] badSpam;

    SpamAnalyzer(String[] badSpam) {
        this.badSpam = badSpam;
    }

    @Override
    public boolean check(String text) {
        for (String i : badSpam) {
            if (text.contains(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public FilterType getFilter() {
        return FilterType.SPAM;
    }
}
