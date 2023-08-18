package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class MergeGroup extends Support implements YamlEvent, WithTypes<MergeGroup.Type> {
    public String name() {
        return "merge_group";
    }

    public static MergeGroup $() {
        return new MergeGroup();
    }

    public MergeGroup types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI {
        CHECKS_REQUESTED;

    }
}
