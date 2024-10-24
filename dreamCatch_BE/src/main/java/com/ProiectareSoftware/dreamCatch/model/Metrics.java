package com.ProiectareSoftware.dreamCatch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "metrics")
public class Metrics implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "emailUser")
    private String emailUser;

    @Column(name = "lvlDuration")
    private Integer lvlDuration;

    @Column(name = "lvlEnergy")
    private Integer lvlEnergy;

    @Column(name = "lvlStress")
    private Integer lvlStress;

    @Column(name = "tag")
    private String tag;
}
