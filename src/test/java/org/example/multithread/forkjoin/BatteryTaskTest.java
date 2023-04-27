package org.example.multithread.forkjoin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DisplayName("BatteryTaskTest class tests")
public class BatteryTaskTest {

    private static final int THRESHOLD = 5000;

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(5_000),
                Arguments.of(10_000),
                Arguments.of(100_000),
                Arguments.of(1_000_000),
                Arguments.of(5_000_000)
        );
    }

    @RepeatedTest(10)
    void shouldWorkSeveralTimes() {
        executeDeviceTaskInPool(3);
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void shouldWorkWithDifferentNumberOfDevices(int numberOfDevices) {
        executeDeviceTaskInPool(numberOfDevices);
    }

    private void executeDeviceTaskInPool(int numberOfDevices) {
        // given
        Device[] devices = generateTestDevices(numberOfDevices);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        BatteryTask batteryTask = new BatteryTask(devices, 5000, 0, devices.length);

        // when
        BigDecimal joinForkSum = forkJoinPool.invoke(batteryTask);
        BigDecimal result = joinForkSum.divide(new BigDecimal(devices.length), BatteryTask.SCALE, RoundingMode.CEILING);

        // then
        assertTrue(result.doubleValue() >= 0);
        assertTrue(result.doubleValue() <= 100);
    }

    @Nested
    @DisplayName("BatteryTaskTest performance tests")
    class Performance {
        private static Stream<Arguments> provideNumbersAndThreshold() {
            return Stream.of(
                    Arguments.of(100_000, THRESHOLD),
                    Arguments.of(5_000_000, THRESHOLD * 2),
                    Arguments.of(20_000_000, THRESHOLD * 100)
            );
        }

        @ParameterizedTest
        @MethodSource("provideNumbersAndThreshold")
        void validatePerformance(int numberOfDevices, int threshold) {
            // given
            Device[] devices = generateTestDevices(numberOfDevices);

            long sequentialSum = 0;

            ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
            BatteryTask batteryTask = new BatteryTask(devices, threshold, 0, devices.length);

            // Sequential
            long beforeSequential = System.currentTimeMillis();
            for (Device device : devices) {
                sequentialSum += device.batteryLevel();
            }
            BigDecimal sequentialResult = (new BigDecimal(sequentialSum)).divide(new BigDecimal(devices.length), BatteryTask.SCALE, RoundingMode.CEILING);
            long afterSequential = System.currentTimeMillis();
            log.info("Execution time of sequential operation is : {}", (afterSequential - beforeSequential));

            // Stream API
            long beforeStreamApi = System.currentTimeMillis();
            double streamApiSum = Arrays.stream(devices).parallel()
                    .mapToDouble(Device::batteryLevel)
                    .average()
                    .orElse(0);
            BigDecimal streamApiResult = new BigDecimal(streamApiSum).divide(BigDecimal.ONE, BatteryTask.SCALE, RoundingMode.CEILING);
            long afterStreamApi = System.currentTimeMillis();
            log.info("Execution time of Stream API operation is : {}", (afterStreamApi - beforeStreamApi));

            // when
            long beforeJoinFork = System.currentTimeMillis();
            BigDecimal joinForkSum = forkJoinPool.invoke(batteryTask);
            BigDecimal joinForkResult = joinForkSum.divide(new BigDecimal(devices.length), BatteryTask.SCALE, RoundingMode.CEILING);
            long afterJoinFork = System.currentTimeMillis();
            log.info("Execution time of Join/Fork operation is : {}", (afterJoinFork - beforeJoinFork));

            // then
            assertEquals(sequentialResult.round(MathContext.DECIMAL64), streamApiResult.round(MathContext.DECIMAL64));
            assertEquals(streamApiResult.round(MathContext.DECIMAL64), joinForkResult.round(MathContext.DECIMAL64));
        }
    }

    private Device[] generateTestDevices(int numberOfDevices) {
        return (new DeviceArrayBuilder(numberOfDevices)).build();
    }

}
