package org.example.yaml.dtos.support;

public interface WithTags {
    String TAGS = "tags";

    WithTags tags(String ... tags);
}
