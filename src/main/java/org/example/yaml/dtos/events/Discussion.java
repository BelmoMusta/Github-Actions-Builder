package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class Discussion extends Support implements YamlEvent, WithTypes<Discussion.Type> {
    public String name() {
        return "discussion";
    }

    public static Discussion $() {
        return new Discussion();
    }

    public Discussion types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI {
        UNLOCKED,
        ANSWERED,
        CATEGORY_CHANGED,
        CREATED,
        DELETED,
        EDITED,
        LABELED,
        LOCKED,
        PINNED,
        TRANSFERRED,
        UNANSWERED,
        UNLABELED,
        UNPINNED;
    }
}
