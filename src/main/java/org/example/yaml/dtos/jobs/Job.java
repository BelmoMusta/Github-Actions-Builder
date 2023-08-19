package org.example.yaml.dtos.jobs;

import org.example.yaml.dtos.Nameable;

import java.util.LinkedHashMap;

public class Job extends LinkedHashMap implements Nameable {

    private String name;
    public static Job $() {
        return new Job();
    }

    public Job name(String name) {
        this.name = name;
        put("name", name);
        return this;
    }
    public Job cancelTimeoutMinutes(int timout) {
        put("cancel-timeout-minutes", timout);
        return this;
    }
    public Job concurrency(Concurrency concurrency) {
        put("concurrency", concurrency);
        return this;
    }
    public Job container(Container container) {
        put("container", container);
        return this;
    }

    public Job environment(String environment) {
        put("environment", environment);
        return this;
    }

    public Job runsOn(String runsOn) {
        put("runs-on", runsOn);
        return this;
    }
    public Job if_(String if_) {
        put("if", if_);
        return this;
    }
    public Job continueOnError(boolean continueOnError) {
        put("continue-on-error", continueOnError);
        return this;
    }
    public Job defaults(Defaults defaults) {
        put("defaults", defaults);
        return this;
    }

    public Job env(String key, String value) {
        Object env = get("env");
        if(env instanceof Env){
            Env exisitingEnv = (Env) env;
            exisitingEnv.put(key,value);
        } else {
            put("env", Env.$(key, value));
        }
        return this;
    }


    @Override
    public String name() {
        return name;
    }
}
