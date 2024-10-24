package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.model.Metrics;

import java.util.List;

public interface IMetricChartData {

    List<Integer> getEntries(List<Metrics> metricsList, IStrategy iStrategy);
}
