package org.example.algorithms.quicksort.pivot;

import java.util.Arrays;

public class RandomPivot extends Pivot {
//    @Override
    public int[] getPivot2(int[] array, int low, int high) {
        int index = (int) ((Math.random() * (high + 1 - low)) + low);
        return new int[] {array[index], index};
    }
    @Override
    public int getPivot(int[] array, int low, int high) {
        int index = (int) ((Math.random() * (high + 1 - low)) + low);
        return array[index];
    }

    @Override
    public int partition(int[] array, int low, int high) {

        int[] pivotArray = getPivot2(array, low, high);
        int pivot = pivotArray[0];
        int pivotIndex = pivotArray[1];

        swap(array, pivotIndex, high);

        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        System.out.println("");

        int leftPtr = low - 1;
        int rightPtr = high;

        while (true) {
            // Searches for numbers strictly bigger than the pivot.
            while (array[++leftPtr] < pivot);
            // Searches for numbers smaller than the pivot.
            while (rightPtr > 0 && array[--rightPtr] > pivot);

            if (leftPtr >= rightPtr)
                break;
            else
                swap(array, leftPtr, rightPtr);
        }

        swap(array, leftPtr, high);

        return leftPtr;
    }
}
