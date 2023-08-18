package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithBranches;
import org.example.yaml.dtos.support.WithIgnoreBranches;
import org.example.yaml.dtos.support.WithIgnorePaths;
import org.example.yaml.dtos.support.WithIgnoreTags;
import org.example.yaml.dtos.support.WithPaths;
import org.example.yaml.dtos.support.WithTags;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class PullRequest extends Support implements YamlEvent,
        WithBranches,
        WithIgnoreBranches,
        WithIgnorePaths,
        WithIgnoreTags,
        WithPaths,
        WithTags,
        WithTypes<PullRequest.Type> {


    public static PullRequest $() {
        return new PullRequest();
    }
    @Override
    public String name() {
        return "push";
    }
    @Override
    public PullRequest branches(String... branches) {
        put(BRANCHES, Arrays.asList(branches));
        return this;
    }
    @Override
    public PullRequest tags(String... tags) {
        put(TAGS, Arrays.asList(tags));
        return this;
    }
    @Override
    public PullRequest paths(String... paths) {
        put(PATHS, Arrays.asList(paths));
        return this;
    }

    @Override
    public PullRequest ignoreBranches(String... branches) {
        putIgnore(BRANCHES, Arrays.asList(branches));
        return this;
    }
    @Override
    public PullRequest ignorePaths(String... paths) {
        putIgnore(PATHS, Arrays.asList(paths));
        return this;
    }
    @Override
    public PullRequest ignoreTags(String... tags) {
        putIgnore(TAGS, Arrays.asList(tags));
        return this;
    }

    @Override
    public PullRequest types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }
    public enum Type implements TypeI {
        ASSIGNED,
        AUTO_MERGE_DISABLED,
        AUTO_MERGE_ENABLED,
        CLOSED,
        CONVERTED_TO_DRAFT,
        EDITED,
        LABELED,
        LOCKED,
        OPENED,
        READY_FOR_REVIEW,
        REOPENED,
        REVIEW_REQUESTED,
        REVIEW_REQUEST_REMOVED,
        SYNCHRONIZE,
        UNASSIGNED,
        UNLABELED,
        UNLOCKED,

        ;
    }
}
