package com.pg.llm.domain;

public class OllamaRequest {

    private String query;

    public OllamaRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
