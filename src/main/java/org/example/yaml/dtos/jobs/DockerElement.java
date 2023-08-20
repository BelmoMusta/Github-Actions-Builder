package org.example.yaml.dtos.jobs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class DockerElement<T extends DockerElement<?>> {
    private String image;
    Map<String, String> env = new LinkedHashMap<>();
    private Credentials credentials;
    Map<String, String> volumes = new LinkedHashMap<>();
    List<Integer> ports = new ArrayList<>();
    private String options;

    public T image(String image) {
        this.image = image;
        return (T) this;
    }

    public String getImage() {
        return image;
    }
    public T volumes(String key, String value) {
        this.volumes.put(key, value);
        return (T) this;
    }
    public T port(int... ports) {
        for (int port : ports) {
            this.ports.add(port);
        }
        return (T) this;
    }

    public T env(String key, String value) {
        env.put(key, value);
        return (T) this;
    }
    public T options(String options) {
        this.options = options;
        return (T) this;
    }
    public T credentials(Credentials credentials) {
        this.credentials = credentials;
        return (T) this;
    }

    public List<Integer> getPorts() {
        return ports;
    }
    public Map<String, String> getEnv() {
        return env;
    }

    public String getOptions() {
        return options;
    }

    public List<String> getVolumes() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> keyValue : volumes.entrySet()) {
            list.add(keyValue.getKey() + ":" + keyValue.getValue());
        }
        return list;
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
