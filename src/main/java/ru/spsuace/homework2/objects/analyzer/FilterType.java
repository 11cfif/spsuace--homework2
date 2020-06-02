package ru.spsuace.homework2.objects.analyzer;

/**
 * Типы фильтров
 */
public enum FilterType {
    SPAM(1), TOO_LONG(2), NEGATIVE_TEXT(3), DUPLICATE(4), GOOD(0);

    /**
     * приоритет типов фильтра
     */
    private final int priority;

    FilterType (int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}