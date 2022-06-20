package com.isu.cs309.biditall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sale_id;

    @ApiModelProperty(notes = "Transaction info associated with a buyer", name = "buyer", value = "test buyer")
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private Buyer buyer;

    @ApiModelProperty(notes = "Transaction info associated with a seller", name = "seller", value = "test seller")
    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonIgnore
    private Seller seller;

    @ApiModelProperty(notes = "Transaction info associated with a item", name = "item", value = "test item")
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ApiModelProperty(notes = "Transaction date", name = "date", required = true, value = "test date")
    @Column(name="date",nullable = false)
    private Date date;

    @ApiModelProperty(notes = "Final cost at transaction", name = "finalPrice", required = true, value = "test finalPrice")
    @Column(name="final_price",nullable = false)
    private Double finalPrice;
}
