class SpamAnalyzer implements TextAnalyzer {

    private String[] badSpam;

    private filterType type;

    public void setType(filterType type) {
        this.type = FilterType.SPAM;
    }

    public FilterType analyse(String text) {
        for (String i : badSpam) {
            if (text.contains(i)) {
                type.setType()
            }
        }
        return type
    }
}
