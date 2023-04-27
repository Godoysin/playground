package org.example.algorithms.quicksort.pivot;

import org.example.algorithms.quicksort.pivot.factory.FirstPivotFactory;
import org.example.algorithms.quicksort.pivot.factory.LastPivotFactory;
import org.example.algorithms.quicksort.pivot.factory.RandomPivotFactory;

public class PivotSwitcher {
    public static Pivot pivotSelector(PivotTypes pivotTypes) {
        return switch (pivotTypes) {
            case FIRST -> new FirstPivotFactory().getPivot();
            case LAST -> new LastPivotFactory().getPivot();
            case RANDOM -> new RandomPivotFactory().getPivot();
        };
    }
}
