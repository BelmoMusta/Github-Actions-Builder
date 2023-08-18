package org.example.yaml.dtos.events;

import org.example.visitor.Visitor;
import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class Issues extends Support implements YamlEvent, WithTypes<Issues.Type> {
    public String name() {
        return "issues";
    }

    public static Issues $() {
        return new Issues();
    }

    public Issues types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI {

        ASSIGNED,
        CLOSED,
        DELETED,
        DEMILESTONED,
        EDITED,
        LABELED,
        LOCKED,
        MILESTONED,
        OPENED,
        PINNED,
        REOPENED,
        TRANSFERRED,
        UNASSIGNED,
        UNLABELED,
        UNLOCKED,
        UNPINNED,

        ;
    }
}
