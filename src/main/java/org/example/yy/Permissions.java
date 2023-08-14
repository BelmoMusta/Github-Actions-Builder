package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.NameValuePair;

public class Permissions extends Nodes {
    public Permissions() {
        super("permissions");
    }

    public static Permissions $() {
        return new Permissions();
    }

    public Permissions actions(Type type) {
        add(new NameValuePair("actions", type.toString()));
        return this;
    }

    public Permissions checks(Type type) {
        add(new NameValuePair("checks", type.toString()));
        return this;
    }

    public Permissions contents(Type type) {
        add(new NameValuePair("contents", type.toString()));
        return this;
    }

    public Permissions deployments(Type type) {
        add(new NameValuePair("deployments", type.toString()));
        return this;
    }

    public Permissions issues(Type type) {
        add(new NameValuePair("issues", type.toString()));
        return this;
    }

    public Permissions discussions(Type type) {
        add(new NameValuePair("discussions", type.toString()));
        return this;
    }

    public Permissions packages(Type type) {
        add(new NameValuePair("packages", type.toString()));
        return this;
    }

    public Permissions statuses(Type type) {
        add(new NameValuePair("statuses", type.toString()));
        return this;
    }

    public Permissions pages(Type type) {
        add(new NameValuePair("pages", type.toString()));
        return this;
    }

    public Permissions idToken(Type type) {
        add(new NameValuePair("id-token", type.toString()));
        return this;
    }

    public Permissions pullRequests(Type type) {
        add(new NameValuePair("pull-requests", type.toString()));
        return this;
    }

    public Permissions repositoryProjects(Type type) {
        add(new NameValuePair("repository-projects", type.toString()));
        return this;
    }

    public Permissions securityEvents(Type type) {
        add(new NameValuePair("security-events", type.toString()));
        return this;
    }


    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type {
        READ,
        WRITE,
        NONE,
        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
