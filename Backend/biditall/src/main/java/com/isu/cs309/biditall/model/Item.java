package com.isu.cs309.biditall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="items")
public class Item {

    private static final int MAX_DESCRIPTION_SIZE = 1024;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    // Connections

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @OneToOne
    private Transaction sale;

    @OneToOne
    private Bids bids;

//    @OneToMany
//    private List<FileData> images;

    // Fields

    @ApiModelProperty(notes = "Item Name",name="name",required=true,value="item_name")
    @Column(name = "item_name", nullable = false)
    private String itemName;

    @ApiModelProperty(notes = "Bid_Price",name="bid_price",required=true,value="bid_prices")
    @Column(name="bid_price",nullable = false)
    private Double bidPrice;

    @ApiModelProperty(notes = "Item Description",name="item_description",required=true,value="description")
    @Column(length = MAX_DESCRIPTION_SIZE)
    private String description;

    @ApiModelProperty(notes = "Buy Now Price",name="buy_now_price",required=true,value="buyPrice")
    @Column(nullable = false)
    private Double buyNowPrice;

    @ApiModelProperty(notes = "End_Date",name="date_end",required=true,value="end")
    @Column(name="end_date",nullable = false)
    private Date endDate;

    @ApiModelProperty(notes = "Posted_Date",name="date_posted",required=true,value="date")
    @Column(name="posted_date",nullable = false)
    private Date postedDate;

}
