package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;

import java.util.Arrays;

public class RepositoryDispatch extends Support implements YamlEvent {

    public String name() {
        return "repository_dispatch";
    }
    public static RepositoryDispatch $() {
        return new RepositoryDispatch();
    }
    public RepositoryDispatch types(String... types) {
        put("types", Arrays.asList(types));
        return this;
    }


}
