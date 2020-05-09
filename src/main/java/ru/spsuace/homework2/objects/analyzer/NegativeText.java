package ru.spsuace.homework2.objects.analyzer;

public class NegativeText extends Spam {

    public NegativeText(FilterType type) {
        super(new String[]{"=(", ":(", ":|"}, type);
    }
}