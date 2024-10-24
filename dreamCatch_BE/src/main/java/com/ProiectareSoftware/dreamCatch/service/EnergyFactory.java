package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.model.Metrics;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnergyFactory implements IMetricChartData{
    @Override
    public List<Integer> getEntries(List<Metrics> metricsList, IStrategy iStrategy) {
        List<Integer> integerList = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusDays(6);
        for(int i = 0; i<7; i++){
            currentDate = startDate.plusDays(i);
            LocalDate finalCurrentDate = currentDate;
            Optional<Metrics> metrics = metricsList.stream()
                    .filter(metrics1 -> LocalDate.ofInstant(metrics1.getDate().toInstant(), ZoneId.systemDefault()).equals(finalCurrentDate))
                    .findFirst();
            if(metrics.isPresent()){
                //if pt fiecare tip de metrica
                integerList.add(metrics.get().getLvlEnergy());
            }
            else{
                integerList.add(0);
            }
        }
        return integerList;
    }
}
