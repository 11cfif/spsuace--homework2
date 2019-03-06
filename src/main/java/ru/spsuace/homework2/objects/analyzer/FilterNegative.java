package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class FilterNegative extends FilterSpam {


    public FilterNegative() {
        super(Arrays.asList("=(", ":(", ":|"), FilterType.NEGATIVE_TEXT);
    }

}
