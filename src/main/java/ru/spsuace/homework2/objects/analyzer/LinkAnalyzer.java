package ru.spsuace.homework2.objects.analyzer;

public class LinkAnalyzer extends SpamAnalyzer{

    final static String[] LINK = {"http://", "https://"};

    public LinkAnalyzer () {
        super(LINK);
    }
}
