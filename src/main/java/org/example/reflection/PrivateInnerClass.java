package org.example.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateInnerClass {

    public static int returnFromPrivate(int num) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Inner.Private innerPrivate = new Inner().new Private();

        Method method = innerPrivate.getClass().getDeclaredMethod("getNumber", int.class);
        method.setAccessible(true);

        return (int) method.invoke(innerPrivate, num);
    }

    static class Inner {
        private class Private {
            private int getNumber(int num) {
                return num * 2;
            }
        }
    }

}
