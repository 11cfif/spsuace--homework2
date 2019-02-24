package ru.spsuace.homework2.objects.analyzer;


import java.util.Collection;

/**
 * Задание написать систему фильтрации комментариев.
 * Надо реализовать три типа обязательных фильтров
 * 1) фильтр для слишком длинных текстов (длина задается при создании) (TOO_LONG)
 * 2) фильтр для спама (передается коллекция плохих слов, которых не должно быть в тексте) (SPAM)
 * 3) фильтр для текстов с плохими эмоциями. (в тексте не должно быть таких смайлов:
 * "=(", ":(", ":|" (NEGATIVE_TEXT)
 * + в качестве доп задания, можете сделать любой свой фильтр (CUSTOM)
 *
 * Класс TextFilterManager должен содержать все фильтры, которые передаются ему в конструкторе,
 * и при анализе текста через метод analyze должен выдавать первый "успешный" фильтр,
 * если не один не прошел, то возвращать тип GOOD.
 * + в качестве доп задания, можно всем типам фильтров задать приоритет
 * (SPAM, TOO_LONG, NEGATIVE_TEXT, CUSTOM - в таком порядке) и возвращать тип с максимальным приоритетом.
 */
public class TextFilterManager{

    Collection<TextAnalyzer> filterList;
    Object element;
    FilterType filterType = FilterType.GOOD;

    public TextFilterManager(Collection<TextAnalyzer> filterList) {
        this.filterList = filterList;
    }

    /**
     * Если переменная текст никуда не ссылается, то это означает, что не один фильтр не сработал
     */
    public FilterType analyze(String text) {

        if (text == null || filterList == null) {
            return FilterType.GOOD;
        }

        for (TextAnalyzer item : filterList) {

            filterType = item.getFilterType();

            switch (filterType){
                case TOO_LONG:
                    if (text.length() > (long)item.getItem()){
                        return FilterType.TOO_LONG;
                    }
                    break;
                case NEGATIVE_TEXT:
                    for (String item1 : (String[]) item.getItem()) {
                        if (text.contains(item1)) {
                            return FilterType.NEGATIVE_TEXT;
                        }
                    }
                    break;
                case SPAM:
                    for (String item1 : (Collection<String>)item.getItem()) {
                        if (text.contains(item1)) {
                            return FilterType.SPAM;
                        }
                    }
                    break;
                default:
                    break;
            }

        }
        return FilterType.GOOD;
    }

}
