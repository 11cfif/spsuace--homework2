package ru.spsuace.homework2.objects.analyzer;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Задание написать систему фильтрации комментариев.
 * Надо реализовать три типа обязательных фильтров
 * 1) фильтр для слишком длинных текстов (длина задается при создании) (TOO_LONG)
 * 2) фильтр для спама (передается коллекция плохих слов, которых не должно быть в тексте) (SPAM)
 * 3) фильтр для текстов с плохими эмоциями. (в тексте не должно быть таких смайлов:
 * "=(", ":(", ":|" (NEGATIVE_TEXT)
 * + в качестве доп задания, можете сделать любой свой фильтр (CUSTOM)
 * <p>
 * Класс TextFilterManager должен содержать все фильтры, которые передаются ему в конструкторе,
 * и при анализе текста через метод analyze должен выдавать первый "успешный" фильтр,
 * если не один не прошел, то возвращать тип GOOD.
 * + в качестве доп задания, можно всем типам фильтров задать приоритет
 * (SPAM, TOO_LONG, NEGATIVE_TEXT, CUSTOM - в таком порядке) и возвращать тип с максимальным приоритетом.
 */
public class TextFilterManager implements TextAnalyzer {
    FilterType filt;
    long maxLenght;
    Collection<TextAnalyzer> filters;
    Collection<String> spam;
    String[] negative = {"=(", ":(", ":|",};

    public TextFilterManager(Collection<TextAnalyzer> filters) {
        this.filters = filters;
    }


    public TextFilterManager(long maxLength) {
        this.maxLenght = maxLength;
        this.filt = FilterType.TOO_LONG;
    }

    public TextFilterManager() {
        this.filt = FilterType.NEGATIVE_TEXT;
    }

    public TextFilterManager(Collection<String> spam, FilterType filter) {
        this.spam = spam;
        this.filt = FilterType.SPAM;
    }


    @Override
    public FilterType textAnalyze(String text) {

        switch (this.filt) {
            case TOO_LONG:
                if (text.length() > this.maxLenght) {
                    return FilterType.TOO_LONG;
                }
                break;
            case SPAM:
                for (String s : spam) {
                    if (text.contains(s)) {
                        return FilterType.SPAM;
                    }
                }

                break;
            case NEGATIVE_TEXT:
                for (String s : negative) {
                    if (text.contains(s)) {
                        return FilterType.NEGATIVE_TEXT;
                    }
                }

                break;
        }
        return FilterType.GOOD;
    }

    /**
     * Если переменная текст никуда не ссылается, то это означает, что не один фильтр не сработал
     */
    public FilterType analyze(String text) {
        if (text != null && filters != null) {
            for (TextAnalyzer i : filters
            ) {
                filt = i.textAnalyze(text);

                if (filt != FilterType.GOOD) {
                    return filt;
                }
            }
        }

        return FilterType.GOOD;
    }
}
