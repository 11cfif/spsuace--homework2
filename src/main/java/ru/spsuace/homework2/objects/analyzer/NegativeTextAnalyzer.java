class NegativeTextAnalyzer implements TextAnalyzer {

    private String[] negativeText = ("=(", ":(",":|")

    public void setType(filterType type) {
        this.type = FilterType.NEGATIVE_TEXT;
    }

    private filterType type;

    public FilterType analyse(String text) {
        for (String i : negativeText) {
            if (text.contains(i)) {
                type.setType()
            }
        }
        return type
    }
}