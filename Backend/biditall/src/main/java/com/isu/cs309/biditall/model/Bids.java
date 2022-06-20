package com.isu.cs309.biditall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "bids")
public class Bids {

    @ApiModelProperty(notes = "Bid Unique ID",name="id",required=true,value="bidID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid_id;

    @ApiModelProperty(notes = "Buyer current bid",name="bidOwner",required=true,value="bidOwnership")
    @ManyToOne
    @JoinColumn(name="buyer_id")
    @JsonIgnore
    private Buyer buyer;

    @ApiModelProperty(notes = "item being bidded",name="itemBid",required=true,value="itemBid")
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ApiModelProperty(notes = "Bid current price",name="price",required=true,value="currPrice")
    @Column(name = "current_price", nullable = false)
    private Double currentPrice;

    @ApiModelProperty(notes = "The Bid Time",name="time",required=true,value="bidTime")
    @Column(name = "bidding_time", nullable = false)
    private String bidTime;

}
