package ru.spsuace.homework2.objects.analyzer;

class SpamAnalyzer implements TextAnalyzer {

    private String[] badSpam;

    SpamAnalyzer(String[] badSpam) {
        this.badSpam = badSpam;
    }

    @Override
    public FilterType analyze(String text) {
        for (String i : badSpam) {
            if (text.contains(i)) {
                return FilterType.SPAM;
            }
        }
        return null;
    }
}
