package com.ProiectareSoftware.dreamCatch.service;

public class MetricsFactory {

    public static IMetricChartData getDataFrom(String type) throws IllegalAccessException {
        switch (type) {
            case "stress":
                return new StressFactory();
            case "energy":
                return new EnergyFactory();
            case "duration":
                return new DurationFactory();
            default:
                throw new IllegalAccessException();
        }
    }
}
