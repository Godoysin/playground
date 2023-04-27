package org.example.algorithms.quicksort.pivot;

public class LastPivot extends Pivot {
//    @Override
//    public int[] getPivot(int[] array, int low, int high) {
//        return new int[] {array[high], high};
//    }
    @Override
    public int getPivot(int[] array, int low, int high) {
        return array[high];
    }

    @Override
    public int partition(int[] array, int low, int high) {
        int pivot = getPivot(array, low, high);

        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                // Increment index of smaller element
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }
}
