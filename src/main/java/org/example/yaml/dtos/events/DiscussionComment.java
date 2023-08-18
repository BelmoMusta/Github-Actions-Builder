package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class DiscussionComment extends Support implements YamlEvent, WithTypes<DiscussionComment.Type> {
    public String name() {
        return ("discussion_comment");
    }

    public static DiscussionComment $() {
        return new DiscussionComment();
    }

    public DiscussionComment types(Type... types) {
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
