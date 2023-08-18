package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;

public class Status implements YamlEvent {
    public Status() {
        super();
    }

    public static Status $() {
        return new Status();
    }

    @Override
    public String name() {
        return "status";
    }
}
