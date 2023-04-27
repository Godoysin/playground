package org.example.exception;

public class Try {

    public static void main(String[] args) {
        // Option A
//        throwException(); // Unhandled exception

        // Option B
//        try {
//            throwException(); // Unhandled exception
//        } // catch or finally expected

        // Option C
        try {
            throwException();
        } catch (Exception e) {
            System.out.println("catch block C");
        }

        // Option D
//        try {
//            throw new Exception("Throw something block D"); // Unhandled exception
//        } finally {
//            System.out.println("finally block D");
//        }

        // Option E
        try {
            try {
                throw new Exception("Throw something block E"); // Unhandled exception
            } finally {
                System.out.println("finally block E");
            }
        } catch (Exception e) {
            System.out.println("catch block E");
        }
    }

    private static void throwException() throws Exception {
        throw new Exception("Throw something");
    }
}
