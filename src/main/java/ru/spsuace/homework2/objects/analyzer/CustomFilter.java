package ru.spsuace.homework2.objects.analyzer;

public class CustomFilter extends SpamFilter{

    public CustomFilter() {
        super(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}, FilterType.CUSTOM);
    }
}
