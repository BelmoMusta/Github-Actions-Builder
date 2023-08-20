package org.example.yaml.dtos.jobs;

import org.example.yaml.dtos.Nameable;

public class Service extends DockerElement<Service> implements Nameable {
    private String name;
    public Service(String name) {
        this.name = name;
    }
    public static Service $(String name) {
        return new Service(name);
    }

    @Override
    public String name() {
        return name;
    }
}
