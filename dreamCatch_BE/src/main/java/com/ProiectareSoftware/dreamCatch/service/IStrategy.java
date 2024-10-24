package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.model.Metrics;

import java.util.List;

public interface IStrategy {

    List<Integer> getListOfDays(List<Metrics> metricsList, String strategy);

}
