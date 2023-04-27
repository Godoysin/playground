package org.example.defavlt;

public interface IDefault {

    int sum(int a, int b);

    default int subtract(int a, int b) {
        return a-b;
    }

}
