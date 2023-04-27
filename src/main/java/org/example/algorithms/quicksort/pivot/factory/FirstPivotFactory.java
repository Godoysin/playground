package org.example.algorithms.quicksort.pivot.factory;

import org.example.algorithms.quicksort.pivot.FirstPivot;
import org.example.algorithms.quicksort.pivot.Pivot;

public class FirstPivotFactory extends PivotFactory {
    @Override
    protected Pivot choosePivot() {
        return new FirstPivot();
    }
}
