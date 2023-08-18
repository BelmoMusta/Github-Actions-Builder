package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class PullRequestReview extends Support implements YamlEvent, WithTypes<PullRequestReview.Type> {

    public String name() {
        return "pull_request_review";
    }
    public static PullRequestReview $() {
        return new PullRequestReview();
    }
    public PullRequestReview types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI {
        DISMISSED,
        EDITED,
        SUBMITTED,

        ;
    }
}
