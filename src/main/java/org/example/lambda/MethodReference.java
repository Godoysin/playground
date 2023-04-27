package org.example.lambda;

public class MethodReference {

    public static final String STATIC_MESSAGE = "Hello, this is static method";
    public static final String INSTANTIATED_MESSAGE = "Hello, this is not a static method";
    private static String saySomethingStatic(){
        return STATIC_MESSAGE;
    }

    private String saySomethingInstantiated(){
        return INSTANTIATED_MESSAGE;
    }

    public static String staticMethodReference() {
        // Referring static method
        FISay say = MethodReference::saySomethingStatic;
        // Calling interface method
        return say.say();
    }

    public static String instantiatedMethodReference() {
        // Referring instantiated method
        FISay say = new MethodReference()::saySomethingInstantiated;
        // Calling interface method
        return say.say();
    }

    public static String constructorMethodReference() {
        FIMessage message = Message::new;

        return message.getMessage().myMessage();
    }
}
