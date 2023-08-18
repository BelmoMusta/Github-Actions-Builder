package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class RegistryPackage extends Support implements YamlEvent, WithTypes<RegistryPackage.Type> {

    public String name() {
        return("registry_package");
    }
    public static RegistryPackage $() {
        return new RegistryPackage();
    }
    public RegistryPackage types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public enum Type implements TypeI{
        PUBLISHED,
        UPDATED;
    }
}
