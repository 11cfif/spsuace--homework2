package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;

public class FilterNegative extends FilterSpam implements TextAnalyzer {
    FilterNegative() {
        String emotions[] = {"=(", ":(", ":|"};
        wordFilter = FilterType.NEGATIVE_TEXT;
    }
}
