package ru.spsuace.homework2.objects.analyzer;

/**
 * Типы фильтров
 */
public enum FilterType {
    SPAM(1), TOO_LONG(3), NEGATIVE_TEXT(2), LINKS(4), GOOD(0);

    private final int priority;

    FilterType (int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}