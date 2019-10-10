package ru.spsuace.homework2.objects.analyzer;


import java.util.logging.Filter;
/**
 * Типы фильтров
 */
public enum FilterType {
    GOOD(5),
    TOO_LONG(3),
    SPAM(1),
    NEGATIVE_TEXT(2),
    CUSTOM(4);

    private final int priority;

    FilterType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
