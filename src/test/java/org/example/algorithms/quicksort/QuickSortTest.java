package org.example.algorithms.quicksort;

import org.example.algorithms.quicksort.pivot.PivotTypes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    private static Stream<Arguments> provideArraysForTesting() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3}),
                Arguments.of(new int[] {3, 5, 1, 4, 11, 3, -1, 0, 0}),
                Arguments.of(new int[] {-3, 7, 11, 4, 11, 3, -1, 0, 3}),
                Arguments.of(new int[] {-3, 7, 11, 4, 11, 3, -1, 0, 11}),
                Arguments.of(new int[] {-3, 7, 11, 4, 11, -3, -1, 0, 11}),
                Arguments.of(new int[] {3, 2, 1}),
                Arguments.of(new int[] {3, 2, 1, 0, -1, -2, -3}),
                Arguments.of(new int[] {1}),
                Arguments.of(new int[] {-3, 7, 11, 4, 11, 3, -1, 0, 11})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForTesting")
    void shouldOrderTheArrayByFirstElementAsPivot(int[] array) {
        // given
        int[] sortedArray = Arrays.stream(Arrays.copyOf(array, array.length)).sorted().toArray();

        // when
        QuickSort.executeQuickSort(PivotTypes.FIRST, array);

        // then
        assertArrayEquals(sortedArray, array);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForTesting")
    void shouldOrderTheArrayByLastElementAsPivot(int[] array) {
        // given
        int[] sortedArray = Arrays.stream(Arrays.copyOf(array, array.length)).sorted().toArray();

        // when
        QuickSort.executeQuickSort(PivotTypes.LAST, array);

        // then
        assertArrayEquals(sortedArray, array);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForTesting")
    void shouldOrderTheArrayByRandomElementAsPivot(int[] array) {
        // given
        int[] sortedArray = Arrays.stream(Arrays.copyOf(array, array.length)).sorted().toArray();

        // when
        QuickSort.executeQuickSort(PivotTypes.RANDOM, array);

        // then
        assertArrayEquals(sortedArray, array);
    }

}
