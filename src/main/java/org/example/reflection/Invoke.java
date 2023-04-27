package org.example.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Invoke {

    public static Class getClassUsingForName() throws ClassNotFoundException {
        return Class.forName("org.example.reflection.ExampleClass");
    }

    public static Class getClassUsingGetClass(Object obj) {
        return obj.getClass();
    }

    public static Class getClassUsingDotClass() {
        return ExampleClass.class;
    }

    public static ExampleClass instanciateExampleClass(Class exampleClass)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (ExampleClass) exampleClass.getDeclaredConstructor().newInstance();
    }

    public static String reachPrivateField(String newMessage) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c = getClassUsingDotClass();
        ExampleClass exampleClass = instanciateExampleClass(c);
        Field field = c.getDeclaredField("privateString"); // Cannot be final field
        field.setAccessible(true);
        field.set(exampleClass, newMessage);

        return exampleClass.getPrivateMessage();
    }

}
