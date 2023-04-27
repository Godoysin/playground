package org.example.algorithms.quicksort.pivot.factory;

import org.example.algorithms.quicksort.pivot.LastPivot;
import org.example.algorithms.quicksort.pivot.Pivot;

public class LastPivotFactory extends PivotFactory {
    @Override
    protected Pivot choosePivot() {
        return new LastPivot();
    }
}
