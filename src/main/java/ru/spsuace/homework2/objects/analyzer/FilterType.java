package ru.spsuace.homework2.objects.analyzer;

/**
 * Типы фильтров
 */
public enum FilterType {

    TOO_LONG(2),
    SPAM(1),
    NEGATIVE_TEXT(3),
    CUSTOM(4),
    GOOD(5);

    private final int number;

    FilterType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
