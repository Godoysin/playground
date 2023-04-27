package org.example.exception;

public class ExceptionTypes {

    public static void throwCheckedException() throws Exception {
        throw new Exception("checked");
    }

    public static void throwUncheckedException() {
        throw new RuntimeException("unchecked");
    }

}
