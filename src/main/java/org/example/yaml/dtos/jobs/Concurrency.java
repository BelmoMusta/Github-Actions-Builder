package org.example.yaml.dtos.jobs;

import java.util.LinkedHashMap;

public class Concurrency extends LinkedHashMap {
    public static Concurrency $(){
        return new Concurrency();
    }

    public Concurrency cancelInProgress(boolean value) {
         put("cancel-in-progress", value);
         return this;
    }
    public Concurrency group(String timout) {
         put("group", timout);
         return this;
    }

}
