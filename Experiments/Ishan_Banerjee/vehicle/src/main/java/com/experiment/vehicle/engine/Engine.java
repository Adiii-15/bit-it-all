package com.experiment.vehicle.engine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private FuelType fuelType;
    private EngineLayout engineLayout;
    private Integer numberOfCylinders;

    public Engine(FuelType fuelType, EngineLayout engineLayout, int numberOfCylinders) {
        this.fuelType = fuelType;
        this.engineLayout = engineLayout;
        this.numberOfCylinders = numberOfCylinders;
    }
}
