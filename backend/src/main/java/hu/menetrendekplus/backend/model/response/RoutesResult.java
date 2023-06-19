package hu.menetrendekplus.backend.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoutesResult {

    private Map<String, Route> talalatok = new HashMap<>();

    public Map<String, Route> getTalalatok() {
        return talalatok;
    }

    public void setTalalatok(Map<String, Route> talalatok) {
        this.talalatok = talalatok;
    }
}
