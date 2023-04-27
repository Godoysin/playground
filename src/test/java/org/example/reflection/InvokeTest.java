package org.example.reflection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvokeTest {

    @Test
    void shouldGetClassUsingForName() {
        // given
        Class c = null;
        // when
        try {
            c = Invoke.getClassUsingForName();
        // then
        } catch (ClassNotFoundException e) {
            fail("Should found the class");
        }

        assertNotNull(c);
        assertEquals(ExampleClass.class.getName(), c.getName());
    }

    @Test
    void shouldGetClassUsingGetClass() {
        // given
        // when
        Class c = Invoke.getClassUsingGetClass(new ExampleClass());

        // then
        assertNotNull(c);
        assertEquals(ExampleClass.class.getName(), c.getName());
    }

    @Test
    void shouldGetClassUsingDotClass() {
        // given
        // when
        Class c = Invoke.getClassUsingDotClass();

        // then
        assertNotNull(c);
        assertEquals(ExampleClass.class.getName(), c.getName());
    }

    @Test
    void shouldGetClassUsingDotClass_AndGetInformationAboutTheInstance() {
        // given
        // when
        Class c = Invoke.getClassUsingDotClass();

        // then
        assertAll(
                "Asserting that the instance is correct",
                () -> assertNotNull(c),
                () -> assertEquals(ExampleClass.class.getName(), c.getName())
        );

        assertAll(
                "Asserting how the instance is",
                () -> assertFalse(c.isAnnotation()),
                () -> assertFalse(c.isEnum()),
                () -> assertFalse(c.isInterface()),
                () -> assertFalse(c.isPrimitive()),
                () -> assertTrue(c.isInstance(new ExampleClass()))
        );

        assertAll(
                "Asserting heritage",
                () -> assertEquals(Object.class, c.getSuperclass()),
                () -> assertEquals(0, c.getInterfaces().length)
        );

        assertAll(
                "Asserting instance information",
                () -> assertEquals(Object.class.getMethods().length + 2, c.getMethods().length),
                () -> assertEquals(1, c.getConstructors().length)
        );
    }

    @Test
    void shouldInstantiateExampleClass() {
        // given
        Class c = Invoke.getClassUsingDotClass();
        ExampleClass exampleClass = null;

        // when
        try {
            exampleClass = Invoke.instanciateExampleClass(c);

        // then
        } catch (Exception e) {
            fail("Should not throw anything");
        }

        final ExampleClass finalExampleClass = exampleClass;
        assertAll(
                () -> assertNotNull(c),
                () -> assertEquals(ExampleClass.MESSAGE, finalExampleClass.classMessage())
        );
    }

    @Test
    void shouldModifyPrivateField() {
        // given
        String s = "new message";
        String oldMessage = (new ExampleClass()).getPrivateMessage();
        String response = null;

        // when
        try {
            response = Invoke.reachPrivateField(s);

        // then
        } catch (Exception e) {
            fail("Should not throw anything");
        }

        final String finalResponse = response;
        assertAll(
                "Asserting private field modification",
                () -> assertNotNull(finalResponse),
                () -> assertEquals(s, finalResponse),
                () -> assertNotEquals(oldMessage, finalResponse)
        );
    }

}
