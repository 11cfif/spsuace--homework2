package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class FilterSpam implements TextAnalyzer {

    private Collection<String> spam;

    FilterSpam(Collection<String> spam){

        this.spam = spam;
    }

    public FilterType textAnalyzer(String text) {

        for ( String sp: spam ) {

            if (text.contains(sp)){
                return FilterType.SPAM;
            }
        }

        return FilterType.GOOD;
    }
}
