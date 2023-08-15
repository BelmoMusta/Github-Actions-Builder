package org.example.actions;

public class Actions {
    public static String $(String name, String version) {
        return "actions/" + name + "@" + version;
    }
    public static String checkout(String version) {
        return $("checkout", version);
    }
    public static String checkoutV3() {
        return checkout("v3");
    }
}
