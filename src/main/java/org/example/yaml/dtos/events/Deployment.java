package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;

public class Deployment implements YamlEvent {
    public String name() {
        return ("deployment");
    }

    public static Deployment $() {
        return new Deployment();
    }

}
