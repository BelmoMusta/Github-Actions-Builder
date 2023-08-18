package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class Watch extends Support implements YamlEvent, WithTypes<Watch.Type> {


    public static Watch $() {
        return new Watch();
    }
    public Watch types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }
    @Override
    public String name() {
        return "watch";
    }

    public enum Type implements TypeI {
        STARTED,

        ;
    }
}
