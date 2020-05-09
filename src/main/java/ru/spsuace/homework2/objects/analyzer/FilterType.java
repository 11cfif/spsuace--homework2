package ru.spsuace.homework2.objects.analyzer;

/**
 * Типы фильтров
 */
public enum FilterType {
    GOOD(0),
    TOO_LONG(2),
    SPAM(1),
    NEGATIVE_TEXT(3);

    private final int PRIORITY;

    FilterType(int priority) {
        this.PRIORITY = priority;
    }

    public int getPriority() {
        return PRIORITY;
    }
}
