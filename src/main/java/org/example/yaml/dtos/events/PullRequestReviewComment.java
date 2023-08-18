package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class PullRequestReviewComment extends Support implements YamlEvent, WithTypes<PullRequestReviewComment.Type> {

    public String name() {
        return "pull_request_review_comment";
    }
    public static PullRequestReviewComment $() {
        return new PullRequestReviewComment();
    }
    public PullRequestReviewComment types(Type... types) {
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
