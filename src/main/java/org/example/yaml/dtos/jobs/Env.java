package org.example.yaml.dtos.jobs;

import java.util.LinkedHashMap;

public class Env extends LinkedHashMap {
    public static Env $(String key, String value){
        Env env = new Env();
        env.put(key, value);
        return env;
    }

}
