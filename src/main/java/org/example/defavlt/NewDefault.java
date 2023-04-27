package org.example.defavlt;

public class NewDefault implements IDefault {

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a*b;
    }

}
