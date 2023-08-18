package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class CheckSuite extends Support implements YamlEvent, WithTypes<CheckSuite.Type> {
    public String name() {
        return ("check_suite");
    }

    public static CheckSuite $() {
        return new CheckSuite();
    }

    public CheckSuite types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI {
        COMPLETED,
        ;
    }
}
