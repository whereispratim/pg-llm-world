package com.pg.llm.domain;

import java.util.List;

public class OllamaResponse {

    private List<String> results;

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}