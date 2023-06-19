package hu.menetrendekplus.backend.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenetrendekResponse<T> {

    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
