package org.example.yaml.dtos.jobs;

import java.util.LinkedHashMap;

public class Defaults extends LinkedHashMap {
    public static Defaults $() {
        return new Defaults();
    }

    public Defaults run(Run run) {
        put("run", run);
        return this;
    }

}
