package org.example.multithread.forkjoin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeviceArrayBuilderTest {

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(10),
                Arguments.of(1_000_000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void shouldGenerateNDevices(int numberOfDevices) {
        // given

        // when
        // Generate the n Devices
        Device[] devices = (new DeviceArrayBuilder(numberOfDevices)).build();

        // then
        // Test that the generated number of devices is right
        assertEquals(numberOfDevices, devices.length);

        // Check that the battery is generated between the borders
        Stream<Integer> filteredBatteryArray = Arrays.stream(devices)
                .map(Device::batteryLevel)
                .filter(e -> e >= 0)
                .filter(e -> e <= 100);
        assertEquals(filteredBatteryArray.toArray().length, devices.length);
    }

}
