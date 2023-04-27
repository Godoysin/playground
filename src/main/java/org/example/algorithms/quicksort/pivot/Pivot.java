package org.example.algorithms.quicksort.pivot;

public abstract class Pivot {

    protected static void swap(int[] array, int elemA, int elemB) {
        int aux = array[elemA];

        array[elemA] = array[elemB];
        array[elemB] = aux;
    }

//    abstract int[] getPivot(int[] array, int low, int high);
    abstract int getPivot(int[] array, int low, int high);

    public abstract int partition(int[] array, int low, int high);

}
