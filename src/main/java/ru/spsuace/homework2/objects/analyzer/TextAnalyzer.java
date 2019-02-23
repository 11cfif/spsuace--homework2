package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

/**
 * Базовый интерефейс фильтра.
 * Ниже надо реализовать методы, которые создают фильтры заданного типа
 */
public interface TextAnalyzer  {

    FilterType textAnalyze(String text);

    static TextAnalyzer createTooLongAnalyzer (long maxLength) {
        return  new TextFilterManager(maxLength);
    }


    static TextAnalyzer createSpamAnalyzer(Collection<String> spam) {
        return  new TextFilterManager(spam,null);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return new TextFilterManager();

    }

    static <T> TextAnalyzer createCustomAnalyzer(T something) {
        return null;
    }


}
