package hu.menetrendekplus.backend.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineInfo {

    private String vonalnev;

    public String getVonalnev() {
        return vonalnev;
    }

    public void setVonalnev(String vonalnev) {
        this.vonalnev = vonalnev;
    }
}
