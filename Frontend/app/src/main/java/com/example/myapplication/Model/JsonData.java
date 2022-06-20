package com.example.myapplication.Model;

import java.util.Date;

/**
 * This class handles parsing from JSON data
 */
public class JsonData {
    private Integer Userid;
    private Integer id;
    private String itemname;
    private String itemDescription;
    private Date endDate;
    private Date postedDate;
   private Double currentPrice;
   private Double buyNowPrice;
   private String img_url;

   public void setImg_url(String img){
       img_url = img;
   }
   public String getImg_url(){
       return img_url;
   }
    public void setUserid(Integer userid) {
        Userid = userid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setBuyNowPrice(Double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public JsonData() {
        Userid = null;
    id = null;
       itemname = null;
        itemDescription = null;
     endDate= null;
    postedDate= null;
      currentPrice= null;
    buyNowPrice= null;
    }

    public Integer getUserid() {
        return Userid;
    }

    public Integer getId() {
        return id;
    }

    public String getItemname() {
        return itemname;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Double getBuyNowPrice() {
        return buyNowPrice;
    }
}
