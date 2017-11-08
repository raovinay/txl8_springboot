package com.rao.gcp.model;

public class SimpleTranslation {
    private final long id;
    private final String message;

    public SimpleTranslation(final long id, final String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
