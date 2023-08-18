package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class Release extends Support implements YamlEvent, WithTypes<Release.Type> {
    public String name() {
        return "release";
    }

    public static Release $() {
        return new Release();
    }

    public Release types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI {
        CREATED,
        DELETED,
        EDITED,
        PRERELEASED,
        PUBLISHED,
        RELEASED,
        UNPUBLISHED,

        ;
    }
}
