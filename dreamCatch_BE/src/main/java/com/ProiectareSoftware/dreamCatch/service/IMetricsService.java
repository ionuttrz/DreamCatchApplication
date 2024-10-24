package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.dto.request.MetricsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;


public interface IMetricsService {

    ResponseEntity<?> addNewEntry(MetricsRequest metricsRequest, Authentication authentication);

    ResponseEntity<?> getStress(Authentication authentication, int days) throws IllegalAccessException;

    ResponseEntity<?> getEnergy(Authentication authentication, int days) throws IllegalAccessException;

    ResponseEntity<?> getDuration(Authentication authentication, int days) throws IllegalAccessException;
}
