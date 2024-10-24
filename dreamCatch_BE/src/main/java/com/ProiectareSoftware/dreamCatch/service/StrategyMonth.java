package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.model.Metrics;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StrategyMonth implements IStrategy{

    @Override
    public List<Integer> getListOfDays(List< Metrics > metricsList, String chartType) {
        List<Integer> integerList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusDays(29);
        for(int i = 0; i<30; i++){
            currentDate = startDate.plusDays(i);
            System.out.println(currentDate);
            LocalDate finalCurrentDate = currentDate;
            Optional<Metrics> metrics = metricsList.stream()
                    .filter(metrics1 -> LocalDate.ofInstant(metrics1.getDate().toInstant(), ZoneId.systemDefault()).equals(finalCurrentDate))
                    .findFirst();
            System.out.println(metrics);
            if(metrics.isPresent()){
                if(chartType.equals("stress")){
                    integerList.add(metrics.get().getLvlStress());
                }
                if(chartType.equals("energy")){
                    integerList.add(metrics.get().getLvlEnergy());
                }
                if(chartType.equals("duration")) {
                    integerList.add(metrics.get().getLvlDuration());
                }
            }
            else{
                integerList.add(0);
            }
        }
        System.out.println("Lista de intregi este " + integerList);
        return integerList;
    }
}
