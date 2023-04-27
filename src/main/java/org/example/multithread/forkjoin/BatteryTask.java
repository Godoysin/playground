package org.example.multithread.forkjoin;

import java.math.BigDecimal;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class BatteryTask extends RecursiveTask<BigDecimal> {

    public static final int SCALE = 16;

    private final Device[] deviceArray;
    private final int threshold;
    private final int startIndex;
    private final int endIndex;

    public BatteryTask(final Device[] deviceArray, final int threshold, final int startIndex, final int endIndex) {
        this.deviceArray = deviceArray;
        this.threshold = threshold;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected BigDecimal compute() {
        BigDecimal result;
        if ((endIndex - startIndex) <= threshold) {
            result = calculateBattery(deviceArray, startIndex, endIndex);
        } else {
            int middleIndex = getMiddleIndex(startIndex, endIndex);
            BatteryTask firstTask = new BatteryTask(deviceArray, threshold, startIndex, middleIndex);
            BatteryTask secondTask = new BatteryTask(deviceArray, threshold, middleIndex, endIndex);

            ForkJoinTask.invokeAll(firstTask, secondTask);
            result = firstTask.join().add(secondTask.join());
        }
        return result;
    }

    private int getMiddleIndex(final int startIndex, final int endIndex) {
        if ((endIndex - startIndex) % 2 == 0)
            return startIndex + ((endIndex - startIndex) / 2);

        return startIndex + (((endIndex + 1) - startIndex) / 2);
    }

    private BigDecimal calculateBattery(final Device[] deviceArray, final int startIndex, final int endIndex) {
        int batterySum = 0;

        for (int i = startIndex; i < endIndex; i++)
            batterySum += deviceArray[i].batteryLevel();

        return new BigDecimal(batterySum);
    }
}
