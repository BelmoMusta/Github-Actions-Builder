package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckRun extends Support implements YamlEvent {
    public String name() {
        return ("check_run");
    }

    public static CheckRun $() {
        return new CheckRun();
    }

    public CheckRun types(Type... types) {
        putEnum("types", Arrays.asList(types));
        return this;
    }

    public enum Type {

        COMPLETED,
        CREATED,
        REQUESTED_ACTION,
        REREQUESTED,

        ;
    }
}
