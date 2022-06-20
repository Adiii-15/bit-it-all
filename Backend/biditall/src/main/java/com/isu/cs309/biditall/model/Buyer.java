package com.isu.cs309.biditall.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Buyer {

    @ApiModelProperty(notes = "buyer_name",name="name",required=true,value="buyerName")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyer_id;

    @ApiModelProperty(notes = "bids",name="userBids",required=true,value="userBidsList")
    @OneToMany
    private List<Bids> myBids;

    @ApiModelProperty(notes = "buyerComment",name="comment",required=true,value="buyerGivenComment")
    private String buyerComment;

    @ApiModelProperty(notes = "buyerRating",name="rating",required=true,value="buyerCurrRating")
    private float rating;
}
