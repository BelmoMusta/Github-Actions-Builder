package org.example.os;

public class Ubuntu {
    public static String latest() {
        return "ubuntu-latest";
    }
    public static String $(String version) {
        return "ubuntu-" + version;
    }
}
