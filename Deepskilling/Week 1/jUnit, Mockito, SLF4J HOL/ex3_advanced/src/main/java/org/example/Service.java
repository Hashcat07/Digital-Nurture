package org.example;

public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String processData() {
        // Adds the "Processed " prefix to whatever the repository returns.
        return "Processed " + repository.getData();
    }
}