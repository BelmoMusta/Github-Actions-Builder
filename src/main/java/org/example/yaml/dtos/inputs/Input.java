package org.example.yaml.dtos.inputs;

import org.example.yaml.dtos.Nameable;

import java.util.LinkedHashMap;

public class Input extends LinkedHashMap implements Nameable {
    private String name;
    public static Input $() {
        return new Input();
    }

    public Input name(String name) {
        this.name = name;
        return this;
    }

    public Input description(String description) {
        put("description", description);
        return this;
    }

    public Input required() {
        return required(true);
    }

    public Input required(boolean value) {
        put("required", value);
        return this;
    }


    public Input type(Type type) {
        put("type", type.name().toLowerCase());
        return this;
    }

    public Input default_(String default_) {
        put("default", default_);
        return this;
    }

    public Input options(String... options) {
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
