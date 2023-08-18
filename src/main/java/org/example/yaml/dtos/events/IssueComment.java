package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class IssueComment extends Support implements YamlEvent, WithTypes<IssueComment.Type> {
    public String name() {
        return "issue_comment";
    }

    public static IssueComment $() {
        return new IssueComment();
    }

    public IssueComment types(Type... types) {
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
