package ru.spsuace.homework2.objects.analyzer;

public class Custom extends Analyzer {

    private final String[] NUM;

    public Custom(String[] custom) {
        super(FilterType.CUSTOM);
        NUM = custom;
    }

    @Override
    public boolean checkFilter(String teleTwo) {
        return teleTwo.matches("\\+7|8?900|901|902|904|908|950|951|952|953|958|977|992|994|996|999?[0-9]{7}");
    }
}
