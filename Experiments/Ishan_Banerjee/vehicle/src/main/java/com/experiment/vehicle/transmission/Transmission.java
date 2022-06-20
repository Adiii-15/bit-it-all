package com.experiment.vehicle.transmission;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TransmissionType transmissionType;
    private Integer gearSpeed;

    public Transmission(TransmissionType transmissionType, Integer gearSpeed) {
        this.transmissionType = transmissionType;
        this.gearSpeed = gearSpeed;
    }
}
