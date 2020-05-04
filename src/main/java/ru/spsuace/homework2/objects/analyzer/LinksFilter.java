package ru.spsuace.homework2.objects.analyzer;

public class LinksFilter extends SpamFilter {
    private static final String[] LINKS = new String[] {"http://", "https://"};

    public LinksFilter() { super(LINKS); }

    @Override
    public FilterType getType() {
        return FilterType.LINKS;
    }
}
