package org.example.algorithms.quicksort.pivot.factory;

import org.example.algorithms.quicksort.pivot.Pivot;
import org.example.algorithms.quicksort.pivot.RandomPivot;

public class RandomPivotFactory extends PivotFactory {
    @Override
    protected Pivot choosePivot() {
        return new RandomPivot();
    }
}
