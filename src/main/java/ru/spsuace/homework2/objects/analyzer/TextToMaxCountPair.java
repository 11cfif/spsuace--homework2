package ru.spsuace.homework2.objects.analyzer;

public class TextToMaxCountPair {
    private final String text;
    private final int maxCount;

    public TextToMaxCountPair(String text, int maxCount) {
        this.text = text;
        this.maxCount = maxCount;
    }

    public String getText() {
        return text;
    }

    public int getMaxCount() {
        return maxCount;
    }
}
