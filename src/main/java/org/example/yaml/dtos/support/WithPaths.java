package org.example.yaml.dtos.support;

public interface WithPaths {
    String PATHS = "paths";

    WithPaths paths(String ... paths);
}
