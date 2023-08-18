package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;


public class Label extends Support implements YamlEvent, WithTypes<Label.Type> {
    public String name() {
        return "label";
    }

    public static Label $() {
        return new Label();
    }

    public Label types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI {

        CREATED,
        DELETED,
        EDITED,

        ;
    }
}
