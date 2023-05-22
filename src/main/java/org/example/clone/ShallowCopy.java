package org.example.clone;

public class ShallowCopy implements Cloneable {

    private int a;
    private String string;

    ShallowCopy() {
        this.string = new String("new String");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Object getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
