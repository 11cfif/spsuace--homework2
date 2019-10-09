package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer extends SpamAnalyzer {

    public NegativeTextAnalyzer(FilterType filter) {
        super(new String[]{"=(", ":(", ":|"}, filter);
    }
}
