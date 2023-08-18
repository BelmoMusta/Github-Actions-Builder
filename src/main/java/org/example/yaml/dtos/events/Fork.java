package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;

public class Fork implements YamlEvent {
    public String name() {
        return "fork";
    }
    public static Fork $() {
        return new Fork();
    }

}
