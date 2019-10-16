package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextFilter extends SpamFilter {

    public NegativeTextFilter() {
        super(new String[]{"=(", ":(", ":|"}, FilterType.NEGATIVE_TEXT);
    }

}