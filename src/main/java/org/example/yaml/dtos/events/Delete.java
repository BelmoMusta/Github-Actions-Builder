package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;

public class Delete implements YamlEvent {
    public String name() {
        return ("delete");
    }

    public static Delete $() {
        return new Delete();
    }
}
