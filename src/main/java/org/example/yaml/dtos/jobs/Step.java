package org.example.yaml.dtos.jobs;

import org.example.yy.Pipe;

import java.util.LinkedHashMap;

public class Step extends LinkedHashMap {
    protected Step() {
    }
    public static Step $() {
        return new Step();
    }

    public Step id(String id) {
        put("id", id);
        return this;
    }

    public Step if_(String condition) {
        put("if", condition);
        return this;
    }

    public Step timeoutMinutes(int minutes) {
        put("timeout-minutes", String.valueOf(minutes));
        return this;
    }

    public Step env(String name, String value) {
        Object env = get("env");
        if (env instanceof Env) {
            Env exisitingEnv = (Env) env;
            exisitingEnv.put(name, value);
        } else {
            put("env", Env.$(name, value));
        }
        return this;
    }


    public Step with(String name, String value) {
        Object with = get("with");
        if (with instanceof Env) {
            Env exisitingEnv = (Env) with;
            exisitingEnv.put(name, value);
        } else {
            put("env", Env.$(name, value));
        }
        return this;
    }

    public Step with(String name, Pipe value) {
        return this;
        //TODO
//        Withs withs = findTag(Withs.class);
//        if (withs == null) {
//            withs = new Withs();
//            add(withs);
//        }
//        With with = new With(name, "|");
//        withs.add(with);
//        withs.add(value);
//        return this;
    }

    public Step name(String name) {
        put("name", name);
        return this;
    }

    public Step workingDirectory(String directory) {
        put("working-directory", directory);
        return this;
    }

    public Step uses(String uses) {
        put("uses", uses);
        return this;
    }

    public Step run(String run) {
        put("run", run);
        return this;
    }

    public Step run(Pipe pipe) {
        return this;
        //todo
//        final Node run;
//        if (children.isEmpty()) {
//            run = new DashSingleElement("run: |");
//        } else {
//            run = new NameValuePair("run", "|");
//        }
//        this.add(run);
//        this.add(pipe);
//        return this;
    }

    public Step continueOnError(boolean continueOnError) {
        put("continue-on-error", continueOnError);
        return this;
    }


    public Step shell(String shell) {
        put("continue-on-error", shell);
        return this;
    }
}
