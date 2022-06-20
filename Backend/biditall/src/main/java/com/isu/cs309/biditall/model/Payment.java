package com.isu.cs309.biditall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_expiration")
    private LocalDate cardExpiration;

    @Column(name = "card_cvv")
    private String cardCVV;

    @Column(name = "card_type")
    private String debitOrCredit;

    @Column(name = "card_issuer")
    private String cardIssuer;

    @Column(name = "bank_name")
    private String bankName;
}