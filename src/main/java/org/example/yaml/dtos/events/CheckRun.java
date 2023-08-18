package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckRun extends Support implements YamlEvent, WithTypes<CheckRun.Type> {
    public String name() {
        return ("check_run");
    }

    public static CheckRun $() {
        return new CheckRun();
    }

    public CheckRun types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI{

        COMPLETED,
        CREATED,
        REQUESTED_ACTION,
        REREQUESTED,

        ;
    }
}
