package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;

public class DeploymentStatus implements YamlEvent {
    public String name() {
        return "deployment_status";
    }

    public static DeploymentStatus $() {
        return new DeploymentStatus();
    }


}
