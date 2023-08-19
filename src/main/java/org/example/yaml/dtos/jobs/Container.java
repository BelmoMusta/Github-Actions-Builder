package org.example.yaml.dtos.jobs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Container {
    Map<String, String> envMap = new LinkedHashMap<>();
    List<Integer> ports = new ArrayList<>();
    Map<String, String> volumes = new LinkedHashMap<>();
    private String image;
    private String options;
    private Credentials credentials;

    public static Container $() {
        return new Container();
    }

    public Container image(String image) {
        this.image = image;
        return this;
    }

    public Container volumes(String key, String value) {
        this.volumes.put(key,value);
        return this;
    }
    public Container port(int... ports) {
        for (int port : ports) {
            this.ports.add(port);
        }
        return this;
    }

    public Container env(String key, String value) {
        envMap.put(key, value);
        return this;
    }
    public Container options(String options) {
        this.options = options;
        return this;
    }
    public Container credentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }


    public List<Integer> getPorts() {
        return ports;
    }
    public Map<String, String> getEnv() {
        return envMap;
    }
    public String getImage() {
        return image;
    }
    public String getOptions() {
        return options;
    }

    public List<String> getVolumes() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> keyValue : volumes.entrySet()) {
            list.add(keyValue.getKey()+":"+keyValue.getValue());
        }
        return list;
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
