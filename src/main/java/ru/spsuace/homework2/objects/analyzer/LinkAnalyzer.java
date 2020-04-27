package ru.spsuace.homework2.objects.analyzer;

public class LinkAnalyzer extends SpamAnalyzer {

    final static String[] LINKS = {"http://", "https://"};

    public LinkAnalyzer() {
        super(LINKS);
    }

    @Override
    public int priority(FilterType type) {
        if (type == FilterType.LINK) {
            return 3;
        }
        return 4;
    }
}
