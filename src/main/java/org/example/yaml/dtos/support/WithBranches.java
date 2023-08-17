package org.example.yaml.dtos.support;

public interface WithBranches {
    String BRANCHES = "branches";

    WithBranches branches(String ... branches);
}
