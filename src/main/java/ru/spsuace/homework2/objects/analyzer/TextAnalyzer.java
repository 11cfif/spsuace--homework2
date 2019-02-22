package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

/**
 * Базовый интерефейс фильтра.
 * Ниже надо реализовать методы, которые создают фильтры заданного типа
 */
public interface TextAnalyzer {


    static TextAnalyzer createTooLongAnalyzer(long maxLength) {

        return null;
    }


    static TextAnalyzer createSpamAnalyzer(Collection<String> spam) {
        return null;
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return null;
    }

    static <T> TextAnalyzer createCustomAnalyzer(T something) {
        return null;
    }


}
