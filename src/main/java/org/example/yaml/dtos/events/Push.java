package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithBranches;
import org.example.yaml.dtos.support.WithIgnoreBranches;
import org.example.yaml.dtos.support.WithIgnorePaths;
import org.example.yaml.dtos.support.WithIgnoreTags;
import org.example.yaml.dtos.support.WithPaths;
import org.example.yaml.dtos.support.WithTags;

import java.util.Arrays;

public class Push extends Support implements YamlEvent,
        WithBranches,
        WithIgnoreBranches,
        WithIgnorePaths,
        WithIgnoreTags,
        WithPaths,
        WithTags {
    public static Push $() {
        return new Push();
    }
    @Override
    public String name() {
        return "push";
    }
    @Override
    public Push branches(String... branches) {
        put(BRANCHES, Arrays.asList(branches));
        return this;
    }
    @Override
    public Push tags(String... tags) {
        put(TAGS, Arrays.asList(tags));
        return this;
    }
    @Override
    public Push paths(String... paths) {
        put(PATHS, Arrays.asList(paths));
        return this;
    }

    @Override
    public Push ignoreBranches(String... branches) {
        putIgnore(BRANCHES, Arrays.asList(branches));
        return this;
    }
    @Override
    public Push ignorePaths(String... paths) {
        putIgnore(PATHS, Arrays.asList(paths));
        return this;
    }
    @Override
    public Push ignoreTags(String... tags) {
        putIgnore(TAGS, Arrays.asList(tags));
        return this;
    }

}
