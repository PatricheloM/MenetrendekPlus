package hu.menetrendekplus.backend.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeInfo {

    private String atszallohely;

    public String getAtszallohely() {
        return atszallohely;
    }

    public void setAtszallohely(String atszallohely) {
        this.atszallohely = atszallohely;
    }
}
