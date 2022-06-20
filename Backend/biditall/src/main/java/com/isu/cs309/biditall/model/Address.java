package com.isu.cs309.biditall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Class used to construct an address
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class
Address {

    @ApiModelProperty(notes = "file_name",name="file",required=true,value="fileInput")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "file_name",name="file",required=true,value="fileInput")
    @OneToOne
    @JsonIgnore
    private User user;

    @ApiModelProperty(notes = "The first line of the address by user",name="firstLine",required=true,value="addrFirstLine")
    @Column(name = "first_line")
    private String addressFirstLine;

    @ApiModelProperty(notes = "The second Line of the address by user",name="secondLine",required=true,value="addrSecondLine")
    @Column(name = "second_line")
    private String addressSecondLine;

    @ApiModelProperty(notes = "City where user lives",name="city_User",required=true,value="city")
    private String city;

    @ApiModelProperty(notes = "State where user lives",name="user_State",required=true,value="state")
    private String state;

    @ApiModelProperty(notes = "User zip code",name="zipCode",required=true,value="zipCode")
    private Integer zip;

    public Address(String addressFirstLine,
                   String addressSecondLine,
                   String city,
                   String state,
                   Integer zip) {
        this.addressFirstLine = addressFirstLine;
        this.addressSecondLine = addressSecondLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
