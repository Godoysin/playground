package org.example.algorithms.quicksort.pivot;

public class FirstPivot extends Pivot {
//    @Override
//    public int[] getPivot(int[] array, int low, int high) {
//        return new int[] {array[low], low};
//    }
    @Override
    public int getPivot(int[] array, int low, int high) {
        return array[low];
    }

    @Override
    public int partition(int[] array, int low, int high) {
        // The last element is chosen as pivot, but other could be chosen.
//        int[] pivotValues = getPivot(array, low, high);
        int pivot = getPivot(array, low, high);
//        int pivot = pivotValues[0];
//        int pivotIndex = pivotValues[1];
        int i = low - 1;
        int j = high;

        while (i < j) {
            i++;
            // Search for a value higher than pivot at the left
            while (array[i] <= pivot && i < j) i++;
            // Search for a value lower than pivot at the right
            while (array[j] > pivot) j--;

            if (i < j)
                swap(array, i, j);
        }
        // At the end, j represents the position that the pivot should have, because all other number below are equal
        // or lower.
        if (array[low] > array[j])
            swap(array, low, j);

        return j;
    }

}
