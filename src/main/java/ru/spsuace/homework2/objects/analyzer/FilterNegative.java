package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;
import java.util.Arrays;

public class FilterNegative extends FilterSpam implements TextAnalyzer {

    FilterNegative() {

        super(Arrays.asList("=(", ":(", ":|"));
        filterName = FilterType.NEGATIVE_TEXT;
    }

}
