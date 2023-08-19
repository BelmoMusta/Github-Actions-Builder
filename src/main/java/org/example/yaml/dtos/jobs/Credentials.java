package org.example.yaml.dtos.jobs;

import java.util.LinkedHashMap;

public class Credentials extends LinkedHashMap {
    public static Credentials $() {
        return new Credentials();
    }

    public Credentials username(String username) {
        put("username", username);
        return this;
    }
    public Credentials password(String password) {
        put("password", password);
        return this;
    }
}
