package com.isu.cs309.biditall.extension;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemModule {
    private String itemName;
    private String itemDescription;
    private Date endDate;
    private Date postedDate;
    private Double currentPrice;
    private Double buyNowPrice;
    private Double startingPrice;
}

