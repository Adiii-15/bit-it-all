package com.experiment.vehicle.owner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int phone;
    private String insurancePolicy;

    public Owner(String name, String email, int phone, String insurancePolicy) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.insurancePolicy = insurancePolicy;
    }
}
