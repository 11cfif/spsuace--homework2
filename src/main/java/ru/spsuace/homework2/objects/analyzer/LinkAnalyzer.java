package ru.spsuace.homework2.objects.analyzer;

public class LinkAnalyzer extends SpamAnalyzer {

    final static String[] LINKS = {"http://", "https://"};

    public LinkAnalyzer() {
        super(LINKS);
    }

    @Override
    public FilterType getFilter() {
        return FilterType.LINK;
    }
}
