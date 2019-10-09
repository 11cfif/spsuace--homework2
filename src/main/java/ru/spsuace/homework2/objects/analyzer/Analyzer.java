package ru.spsuace.homework2.objects.analyzer;

public class Analyzer implements TextAnalyzer {
    private String[] Spam;
    private String[] Negativ= {"=(",":(",":|"};
    private long MaxLength;
    private final FilterType Type;

    public Analyzer(FilterType type){
        Type=type;
    }
    public boolean ApplyFilter(String Text){
        switch (Type){

            case TooLongAnalyzer:
                if (Text.length() > MaxLength) {
                    return true;
                }
                break;
            case SpamAnalyzer:
                for (String mask : Spam) {
                    if (Text.contains(mask)) {
                        return true;
                    }
                }
                    break;

            case NegativeTextAnalyzer:
                for (String mask: Negativ){
                    if (Text.contains(mask)){
                        return true;
                    }
                }
                break;
        }
        return false;
    }
    public void SetSpam (String[] spam){
        Spam=spam;
    }
    public FilterType GetFilterType(){
        return Type;
    }
    public void SetMaxLength(long maxLength){
        MaxLength=maxLength;
    }
}
