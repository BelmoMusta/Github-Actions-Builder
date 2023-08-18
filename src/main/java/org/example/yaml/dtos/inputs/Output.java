package org.example.yaml.dtos.inputs;

import org.example.yaml.dtos.Nameable;

import java.util.LinkedHashMap;

public class Output extends LinkedHashMap implements Nameable {
    private String name;
    public static Output $() {
        return new Output();
    }

    public Output name(String name) {
        this.name = name;
        return this;
    }

    public Output description(String description) {
        put("description", description);
        return this;
    }
    public Output value(String value) {
        put("value", value);
        return this;
    }

    public Output required() {
        return required(true);
    }

    public Output required(boolean value) {
        put("required", value);
        return this;
    }


    public Output type(Type type) {
        put("type", type.name().toLowerCase());
        return this;
    }

    public Output default_(String default_) {
        put("default", default_);
        return this;
    }

    public Output options(String... options) {
        put("options", options);
        return this;
    }

    @Override
    public String name() {
        return name;
    }

    public enum Type {
        CHOICE,
        ENVIRONMENT,
        BOOLEAN,
        STRING;


    }
}
