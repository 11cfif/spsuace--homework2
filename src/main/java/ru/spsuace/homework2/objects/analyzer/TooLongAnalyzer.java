class ToLongAnalyzer implements TextAnalyzer {

    private long lenghtStrinng

    private filterType type

    public void setType(filterType type) {
        this.type = FilterType.TOO_LONG;
    }

    public FilterType analyse(String text) {
        if (lenghtStrinng <= text.lenght()) {
            type.setType()
        }
        return type
    }
}
