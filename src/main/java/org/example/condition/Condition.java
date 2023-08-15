package org.example.condition;

public class Condition {


    public static String $(String condition) {
        return "${{ " + condition + " }}";
    }
    public static String sucess() {
        return $("sucess()");
    }
    public static String always() {
        return $("always()");
    }
    public static String cancelled() {
        return $("cancelled()");
    }
    public static String failure() {
        return $("failure()");
    }
}
