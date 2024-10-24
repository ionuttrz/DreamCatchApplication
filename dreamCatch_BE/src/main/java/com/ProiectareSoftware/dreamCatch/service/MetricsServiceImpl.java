package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.dto.request.MetricsRequest;
import com.ProiectareSoftware.dreamCatch.model.Metrics;
import com.ProiectareSoftware.dreamCatch.repository.MetricsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MetricsServiceImpl implements IMetricsService {

    @Autowired
    MetricsRepository metricsRepository;

    @Override
    public ResponseEntity<?> addNewEntry(MetricsRequest metricsRequest, Authentication authentication) {
        String email = authentication.getName();
        Boolean isDate = metricsRepository.existsByDateAndEmailUser(metricsRequest.getDate(), email);
        System.out.println(isDate);
       if(isDate) {
            return ResponseEntity.badRequest().body("Error: An entry was already created for this date.");
        }


        // Create new entry in table
        Metrics metrics = new Metrics();

        metrics.setEmailUser(email);
        metrics.setDate(metricsRequest.getDate());
        metrics.setLvlDuration(metricsRequest.getLvlDuration());
        metrics.setLvlEnergy(metricsRequest.getLvlEnergy());
        metrics.setLvlStress(metricsRequest.getLvlStress());
        metrics.setTag(metricsRequest.getTag());

        metrics = metricsRepository.save(metrics);

        return ResponseEntity.ok(metrics);
    }

    @Override
    public ResponseEntity<?> getStress(Authentication authentication, int days) throws IllegalAccessException {
        List<Metrics> stressMetrics;
        String email = authentication.getName();
        IStrategy iStrategy = Strategy.getDays(days);
        LocalDate currentDate = LocalDate.now();
        Date startDate = Date.from(currentDate.minusDays(days).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(currentDate.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        stressMetrics = metricsRepository.findByDatesInRange(startDate, endDate, email);
        return ResponseEntity.ok(iStrategy.getListOfDays(stressMetrics, "stress"));
    }

    @Override
    public ResponseEntity<?> getEnergy(Authentication authentication, int days) throws IllegalAccessException {
        List<Metrics> energyMetrics;
        String email = authentication.getName();
        IStrategy iStrategy = Strategy.getDays(days);
        LocalDate currentDate = LocalDate.now();
        Date startDate = Date.from(currentDate.minusDays(days).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(currentDate.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        energyMetrics = metricsRepository.findByDatesInRange(startDate, endDate, email);
        return ResponseEntity.ok(iStrategy.getListOfDays(energyMetrics, "energy"));
    }

    @Override
    public ResponseEntity<?> getDuration(Authentication authentication, int days) throws IllegalAccessException {
        List<Metrics> durationMetrics;
        String email = authentication.getName();
        IStrategy iStrategy = Strategy.getDays(days);
        LocalDate currentDate = LocalDate.now();
        Date startDate = Date.from(currentDate.minusDays(days).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(currentDate.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        durationMetrics = metricsRepository.findByDatesInRange(startDate, endDate, email);
        return ResponseEntity.ok(iStrategy.getListOfDays(durationMetrics, "duration"));
    }
}
