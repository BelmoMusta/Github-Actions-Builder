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

public class PullRequestTarget extends Support implements YamlEvent,
        WithBranches,
        WithIgnoreBranches,
        WithIgnorePaths,
        WithIgnoreTags,
        WithPaths,
        WithTags,
        WithTypes<PullRequestTarget.Type> {

    public String name() {
        return "pull_request_target";
    }

    @Override
    public PullRequestTarget branches(String... branches) {
        put(BRANCHES, Arrays.asList(branches));
        return this;
    }
    @Override
    public PullRequestTarget tags(String... tags) {
        put(TAGS, Arrays.asList(tags));
        return this;
    }
    @Override
    public PullRequestTarget paths(String... paths) {
        put(PATHS, Arrays.asList(paths));
        return this;
    }

    @Override
    public PullRequestTarget ignoreBranches(String... branches) {
        putIgnore(BRANCHES, Arrays.asList(branches));
        return this;
    }
    @Override
    public PullRequestTarget ignorePaths(String... paths) {
        putIgnore(PATHS, Arrays.asList(paths));
        return this;
    }
    @Override
    public PullRequestTarget ignoreTags(String... tags) {
        putIgnore(TAGS, Arrays.asList(tags));
        return this;
    }

    @Override
    public PullRequestTarget types(PullRequestTarget.Type... types) {
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
        REVIEW_REQUEST_REMOVED,
        REVIEW_REQUESTED,
        SYNCHRONIZE,
        UNASSIGNED,
        UNLABELED,
        UNLOCKED,

        ;
    }
}
