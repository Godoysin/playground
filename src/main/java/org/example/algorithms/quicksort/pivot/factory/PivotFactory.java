package org.example.algorithms.quicksort.pivot.factory;

import org.example.algorithms.quicksort.pivot.Pivot;

public abstract class PivotFactory {

    public Pivot getPivot() {
        return choosePivot();
    }

    protected abstract Pivot choosePivot();

}
