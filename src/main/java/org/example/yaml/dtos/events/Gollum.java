package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;

public class Gollum implements YamlEvent {
    public String name() {
        return "gollum";
    }
    public static Gollum $() {
        return new Gollum();
    }

}
