package ru.spsuace.homework2.objects.analyzer;

/**
 * Типы фильтров
 */
public enum FilterType {
    GOOD(0), TOO_LONG(2), SPAM(1), NEGATIVE_TEXT(3), LINK(4);

    private final int priority;

    FilterType (int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
