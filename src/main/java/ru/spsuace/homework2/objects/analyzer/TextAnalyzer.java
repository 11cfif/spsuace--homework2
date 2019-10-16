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
    FilterType processText(String text);
}

abstract class Analyzer implements TextAnalyzer { //реализация интерфейса

    protected abstract String[] getKeywords(); //когда от реализации можно отказаться используется abstract

    protected abstract FilterType getLabel();

    public FilterType processText(String text) { //здесь хранится массив строк которые мы проверяем
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return FilterType.GOOD;
    }

    class createTooLongAnalyzer implements TextAnalyzer {
        private long maxLength;

        public createTooLongAnalyzer(int threshold) {
            this.maxLength = threshold;
        }

        @Override
        public FilterType processText(String text) {
            if (text.length() > maxLength)
                return FilterType.TOO_LONG;
            else
                return FilterType.GOOD;
        }

    }

    class createSpamAnalyzer extends Analyzer implements TextAnalyzer {
        private String[] keywords;

        public createSpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected FilterType getLabel() {
            return FilterType.SPAM;
        }

    }

    class createNegativeTextAnalyzer extends Analyzer implements TextAnalyzer {
        private final String[] KEYWORDS = {"=(", ":(", ":|"};

        @Override
        protected String[] getKeywords() {
            return KEYWORDS;
        }

        @Override
        protected FilterType getLabel() {
            return FilterType.NEGATIVE_TEXT;
        }

    }

    /**
     * Дополнительное задание: придумать свой фильтр
     */
    class createCustomAnalyzer implements TextAnalyzer {
        public FilterType processText(String text) {
            if (text == null || text.isEmpty()) {
                return FilterType.GOOD;
            }
            if (text.equals(text.toUpperCase())) {
                return FilterType.CAPS_LOCK;
            }
            return FilterType.GOOD;
        }

        public FilterType checkLabels(TextAnalyzer[] analyzers, String text) {
            for (int i = 0; i < analyzers.length; i++)
                if (analyzers[i].processText(text) != FilterType.GOOD)
                    return analyzers[i].processText(text);
            return FilterType.GOOD;
        }
    }
}
