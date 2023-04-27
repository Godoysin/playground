package org.example.generics;

public class Box<T> {

    private final T t;

    public Box(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    /**
     * This works perfectly
    public void print(Integer i) {
        System.out.println(i);
    }
    public void print(Double d) {
        System.out.println(d);
    }
    **/

    /**
     * This throws: 'print(Set<Integer>)' clashes with 'print(Set<Double>)'; both methods have same erasure
    public void print(Set<Integer> i) {
        System.out.println(i);
    }
    public void print(Set<Double> d) {
        System.out.println(d);
    }
    **/

}
