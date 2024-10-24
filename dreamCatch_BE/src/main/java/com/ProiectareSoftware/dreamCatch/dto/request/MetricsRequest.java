package com.ProiectareSoftware.dreamCatch.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricsRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Integer lvlDuration;

    private Integer lvlEnergy;

    private Integer lvlStress;

    private String tag;
}
