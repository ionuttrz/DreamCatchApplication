package com.ProiectareSoftware.dreamCatch.repository;

import com.ProiectareSoftware.dreamCatch.model.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MetricsRepository extends JpaRepository<Metrics, Integer> {

    Boolean existsByDateAndEmailUser(Date date, String emailUser);

    @Query("SELECT DISTINCT m FROM Metrics m WHERE m.date >= :startDate AND m.date <= :endDate AND m.emailUser = :email")
    List<Metrics> findByDatesInRange(Date startDate, Date endDate, String email);
}
