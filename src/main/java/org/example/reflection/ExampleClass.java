package org.example.reflection;

public class ExampleClass {

    public static final String MESSAGE = "class message";

    private static String privateString = "private message";

    public String classMessage() {
        return MESSAGE;
    }

    public String getPrivateMessage() {
        return privateString;
    }



}
