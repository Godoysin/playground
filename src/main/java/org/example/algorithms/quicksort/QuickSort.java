package org.example.algorithms.quicksort;

import org.example.algorithms.quicksort.pivot.Pivot;
import org.example.algorithms.quicksort.pivot.PivotSwitcher;
import org.example.algorithms.quicksort.pivot.PivotTypes;

import java.util.Arrays;

public class QuickSort {

    private static Pivot pivotChooser;

    private QuickSort() {}

    public static void executeQuickSort(PivotTypes pivotTypes, int[] array) {
        pivotChooser = PivotSwitcher.pivotSelector(pivotTypes);

        int n = array.length;

        quickSort(array, 0, n - 1);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = pivotChooser.partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

}
