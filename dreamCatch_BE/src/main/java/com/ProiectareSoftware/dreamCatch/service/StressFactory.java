package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.model.Metrics;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class StressFactory implements IMetricChartData{

    @Override
    public List<Integer> getEntries(List<Metrics> metricsList, IStrategy iStrategy) {
        List<Integer> integerList = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusDays(29);
        for(int i = 0; i<30; i++){
            currentDate = startDate.plusDays(i);
            System.out.println(currentDate);
            LocalDate finalCurrentDate = currentDate;
            //System.out.println("data finala"+finalCurrentDate);
            Optional<Metrics> metrics = metricsList.stream()
                    .filter(metrics1 -> LocalDate.ofInstant(metrics1.getDate().toInstant(), ZoneId.systemDefault()).equals(finalCurrentDate))
                    .findFirst();
            System.out.println(metrics);
            if(metrics.isPresent()){
                integerList.add(metrics.get().getLvlStress());
            }
            else{
                integerList.add(0);
            }
        }
        System.out.println("Lista de intregi este " + integerList);
        return integerList;
    }
}
