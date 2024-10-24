package com.ProiectareSoftware.dreamCatch.controller;

import com.ProiectareSoftware.dreamCatch.dto.request.MetricsRequest;
import com.ProiectareSoftware.dreamCatch.service.IMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/metrics")
@CrossOrigin(origins = "*")
public class MetricsController {

    @Autowired
    IMetricsService IMetricsService;

    @PostMapping("/addEntry")
    public ResponseEntity<?> addNewEntry(@RequestBody MetricsRequest metricsRequest, Authentication accessToken) {
        System.out.println(accessToken.getName());
        return IMetricsService.addNewEntry(metricsRequest, accessToken);
    }

    @GetMapping("/getStress")
    public ResponseEntity<?> getStress(Authentication accessToken, @RequestParam int days) throws IllegalAccessException {
        return IMetricsService.getStress(accessToken, days);
    }

    @GetMapping("/getEnergy")
    public ResponseEntity<?> getEnergy(Authentication accessToken, @RequestParam int days) throws IllegalAccessException {
        return IMetricsService.getEnergy(accessToken, days);
    }

    @GetMapping("/getDuration")
    public ResponseEntity<?> getDuration(Authentication accessToken, @RequestParam int days) throws IllegalAccessException {
        return IMetricsService.getDuration(accessToken, days);
    }
}
