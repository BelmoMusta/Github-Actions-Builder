package org.example.yaml.dtos.support;

public interface WithTypes<T extends WithTypes.TypeI> {
    String TYPES = "types";
    WithTypes types(T ... types);
    interface TypeI{}
}
