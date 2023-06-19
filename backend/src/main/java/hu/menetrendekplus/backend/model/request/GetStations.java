package hu.menetrendekplus.backend.model.request;

import java.util.List;

public class GetStations {

    private String inputText;

    private final List<String> searchIn = List.of("stations");

    private int maxResults;

    private final List<Integer> networks = List.of(1);

    private final String currentLang = "hu";

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public List<String> getSearchIn() {
        return searchIn;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public List<Integer> getNetworks() {
        return networks;
    }

    public String getCurrentLang() {
        return currentLang;
    }
}
