package ru.spsuace.homework2.objects.analyzer;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new TooLong(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return  new Spam(spam);
    }

        static TextAnalyzer createNegativeTextAnalyzer() {
            return  new Negative();
        }


    /**
     * Дополнительное задание: придумать свой фильтр
     */
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    static TextAnalyzer createDuplicateAnalyzer(ToMaxCountPair textToMaxCountPair) {
        return (TextAnalyzer) new DuplicateTextAnalyzer(textToMaxCountPair);
    }

    FilterType analyze(String text);


    /**
     * фильтр для проверки повторов слов в тексте
     */


    public class DuplicateTextAnalyzer {
        private final ToMaxCountPair textToMaxCountPair;

        public DuplicateTextAnalyzer(ToMaxCountPair textToMaxCountPair) {
            this.textToMaxCountPair = textToMaxCountPair;
        }


        public boolean checkText(String text) {
            if (textToMaxCountPair == null || textToMaxCountPair.getText() == null || textToMaxCountPair.getMaxCount() < 0 ||
                    text.length() < textToMaxCountPair.getText().length()) {
                return false;
            }

            int count = 0;
            String copyText = text;

            while (!copyText.isEmpty() && copyText.contains(textToMaxCountPair.getText())) {
                copyText = copyText.replaceFirst(textToMaxCountPair.getText(), "");
                count++;
            }

            return count > textToMaxCountPair.getMaxCount();
        }


        public FilterType getFilterType() {
            return FilterType.DUPLICATE;
        }
    }
}