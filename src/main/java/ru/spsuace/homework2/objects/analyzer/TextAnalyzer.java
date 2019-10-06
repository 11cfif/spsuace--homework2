package ru.spsuace.homework2.objects.analyzer;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Базовый интерефейс фильтра, наследники этого интерефейса должны инкапсулировать в себе всю логику
 * анализа текста.
 * Ниже надо реализовать методы, которые создают фильтры заданного типа (то что они возвращают интерфейс, это как раз
 * прием ООП, где нам не важна конкретная реализация, а важен только контракт, что результат статических методов
 * умеет как-то анализировать текст). Сами статические методы мне нужны для создания тестов,
 * что бы без реальных классов (которые вы напишите) я смог "сэмулировать" их создание.
 * <p>
 * Так же необходимо создать все необходимы методы, которые будут вам нужны для прогона текста
 * по всем фильтрам в классе TextFilterManager
 */


public interface TextAnalyzer {

    FilterType ApplyFilter(String text);

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {

        return new TooLongText(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {

        return new BadWordsInText(spam);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {

        return new BadEmotionsInText();
    }

    /**
     * Дополнительное задание: придумать свой фильтр
     */
    static TextAnalyzer createCustomTextAnalyzer() {

        return new LinksInText();
    }
}

class TooLongText implements TextAnalyzer {
    private final long maxLength;

    public TooLongText(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType ApplyFilter(String text) {
        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}

class BadWordsInText implements TextAnalyzer {
    private final String[] arrayBadWords;

    public BadWordsInText(String[] arrayBadWords) {
        this.arrayBadWords = arrayBadWords;
    }

    @Override
    public FilterType ApplyFilter(String text) {
        for (String elementArray : arrayBadWords)
            if (text.contains(elementArray)) {
                return FilterType.SPAM;
            }
        return FilterType.GOOD;
    }
}

class BadEmotionsInText implements TextAnalyzer {
    private final String[] arrayBadEmotions = {"=(", ":(", ":|"};

    public BadEmotionsInText() {
    }

    @Override
    public FilterType ApplyFilter(String text) {
        for (String elementArray : arrayBadEmotions) {
            if (text.contains(elementArray)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}

class LinksInText implements TextAnalyzer {
    final String regexLink = "(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";

    public LinksInText() {
    }

    final Pattern pattern = Pattern.compile(regexLink);

    public FilterType ApplyFilter(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }
}