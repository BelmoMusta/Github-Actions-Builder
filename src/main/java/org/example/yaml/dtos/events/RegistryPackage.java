package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;

import java.util.Arrays;

public class RegistryPackage extends Support implements YamlEvent {

    public String name() {
        return("registry_package");
    }
    public static RegistryPackage $() {
        return new RegistryPackage();
    }
    public RegistryPackage types(Type... types) {
        putEnum("types", Arrays.asList(types));

        return this;
    }

    public enum Type {
        PUBLISHED,
        UPDATED;
    }
}
