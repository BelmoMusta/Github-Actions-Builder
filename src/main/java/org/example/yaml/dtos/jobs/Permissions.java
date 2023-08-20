package org.example.yaml.dtos.jobs;

import java.util.LinkedHashMap;

public class Permissions extends LinkedHashMap {

    public static Permissions $() {
        return new Permissions();
    }

    private Permissions addType(String name, Type type) {
        put(name, type.name().toLowerCase());
        return this;
    }
    public Permissions actions(Type type) {
        return addType("actions", type);
    }

    public Permissions checks(Type type) {
        return addType("checks", type);
    }

    public Permissions contents(Type type) {
        return addType("contents", type);
    }

    public Permissions deployments(Type type) {
        return addType("deployments", type);
    }

    public Permissions issues(Type type) {
        return addType("issues", type);
    }

    public Permissions discussions(Type type) {
        return addType("discussions", type);
    }

    public Permissions packages(Type type) {
        return addType("packages", type);
    }

    public Permissions statuses(Type type) {
        return addType("statuses", type);
    }

    public Permissions pages(Type type) {
        return addType("pages", type);
    }

    public Permissions idToken(Type type) {
        return addType("idToken", type);
    }

    public Permissions pullRequests(Type type) {
        return addType("pull-requests", type);
    }

    public Permissions repositoryProjects(Type type) {
        return addType("repository-projects", type);
    }

    public Permissions securityEvents(Type type) {
        return addType("security-events", type);
    }
    public enum Type {
        READ,
        WRITE,
        NONE,
        ;

    }
}
