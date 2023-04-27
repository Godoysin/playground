package org.example.algorithms.quicksort.pivot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPivotTest {

    RandomPivot randomPivot = new RandomPivot();

    @Test
    void shouldPutThePivotInItsPlace() {
        // given
        int[] array = new int[] {3, 1, 2};
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        int low = 0;
        int high = array.length - 1;

        // when
        int index = randomPivot.partition(array, low, high);

        // then
        assertEquals (sortedArray[index], array[index]);
    }

}
