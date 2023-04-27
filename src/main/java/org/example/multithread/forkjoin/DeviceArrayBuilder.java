package org.example.multithread.forkjoin;

public class DeviceArrayBuilder {

    private final static int MIN_BATTERY = 0;
    private final static int MAX_BATTERY = 100;

    private int numberOfDevices;

    private DeviceArrayBuilder() {}

    public DeviceArrayBuilder(final int numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }

    public Device[] build() {
        if (numberOfDevices <= 0)
            return new Device[] {};

        Device[] devices = new Device[numberOfDevices];
        for (int i = 0; i < numberOfDevices; i++) {
            devices[i] = new Device(String.valueOf(i), generateRandomBattery());
        }
        return devices;
    }

    private int generateRandomBattery() {
        return (int) Math.floor(Math.random() * (MAX_BATTERY - MIN_BATTERY + 1) + MIN_BATTERY);
    }
}
