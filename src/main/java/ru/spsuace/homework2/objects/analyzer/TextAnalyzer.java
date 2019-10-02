package ru.spsuace.homework2.objects.analyzer;

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
    public class FilterLong implements TextAnalyzer {

        private long maxLength;

        FilterLong(long maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public FilterType doFilter(String str) {
            if (str.length() > maxLength) {
                return FilterType.TOO_LONG;
            }
            return FilterType.GOOD;
        }
    }

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new FilterLong(maxLength);
    }

    public class FilterSpam implements TextAnalyzer {

        private String[] spamWord;

        public FilterSpam(String[] spamWord) {
            this.spamWord = spamWord;
        }

        @Override
        public FilterType doFilter(String str) {
            for (String word : spamWord) {
                if (str.contains(word)) {
                    return FilterType.SPAM;
                }
            }
            return FilterType.GOOD;
        }
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return new FilterSpam(spam);
    }

    public class FilterNegative implements TextAnalyzer {

        String emotions[] = {"=(", ":(", ":|"};

        @Override
        public FilterType doFilter(String str) {
            for (String smile : emotions) {
                if (str.contains(smile)) {
                    return FilterType.NEGATIVE_TEXT;
                }
            }
            return FilterType.GOOD;
        }
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return new FilterNegative();
    }

    public FilterType doFilter(String str);

    /**
     * Дополнительное задание: придумать свой фильтр
     */
    static <T> TextAnalyzer createCustomAnalyzer(T something) {
        return null;
    }
}