package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class PullRequestComment extends Support implements YamlEvent, WithTypes<PullRequestComment.Type> {

    public String name() {
        return "pull_request_comment";
    }
    public static PullRequestComment $() {
        return new PullRequestComment();
    }
    public PullRequestComment types(Type... types) {
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
