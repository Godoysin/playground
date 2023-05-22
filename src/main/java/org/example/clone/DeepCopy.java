package org.example.clone;

public class DeepCopy implements Cloneable {

    private int a;
    private String string;

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepCopy deepCopy = (DeepCopy) super.clone();
        deepCopy.setString(new String());
        return deepCopy;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
