package com.ProiectareSoftware.dreamCatch.dto;

import com.ProiectareSoftware.dreamCatch.model.Metrics;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricsDTO {

    private Integer id;

    private String emailUser;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Integer lvlDuration;

    private Integer lvlEnergy;

    private Integer lvlStress;

    private String tag;

    public MetricsDTO(Metrics metrics) {
        this.id = metrics.getId();
        this.emailUser = metrics.getEmailUser();
        this.date = metrics.getDate();
        this.lvlDuration = metrics.getLvlDuration();
        this.lvlEnergy = metrics.getLvlEnergy();
        this.lvlStress = metrics.getLvlStress();
        this.tag = metrics.getTag();
    }
}
