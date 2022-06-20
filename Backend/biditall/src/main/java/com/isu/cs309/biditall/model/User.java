/**
 * @author Ishan Banerjee
 */
package com.isu.cs309.biditall.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * User class represents both a buyer, Seller and Admin tables.
 * This class is the abstract class that acts as the parent class
 * for the buyer and the seller class.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    private static final int MAX_NAME_WIDTH = 64;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    // Connections

    @ApiModelProperty(notes = "Login info of a user", name = "login", required = true, value = "test login")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;

    @ApiModelProperty(notes = "Address info of user", name = "address", required = true, value = "test address")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ApiModelProperty(notes = "Seller info is user is a seller", name = "seller", value = "test seller")
    @OneToOne
    private Seller seller;

    @ApiModelProperty(notes = "Item's associated with a user", name = "items", value = "test items")
    @OneToMany
    private List<Item> items;

    @ApiModelProperty(notes = "Payment info(s) related to a user", name = "cards", value = "test cards")
    @OneToMany
    private List<Payment> cards;

    // Fields
    @ApiModelProperty(notes = "User's firstname", name = "first_name", required = true, value = "test firstname")
    @Column(name = "first_name", nullable = false, length = MAX_NAME_WIDTH)
    private String firstName;

    @ApiModelProperty(notes = "User's lastname", name = "last_name", required = true, value = "test lastname")
    @Column(name = "last_name", nullable = false, length = MAX_NAME_WIDTH)
    private String lastName;

    @ApiModelProperty(notes = "User's email address", name = "email", required = true, value = "test email")
    @Column(nullable = false)
    private String email;

    @ApiModelProperty(notes = "User's phone number", name = "login", required = true, value = "test phone-number")
    @Column(name="phone_number", unique = true)
    private String phoneNumber;

    @ApiModelProperty(notes = "User's data of birth", name = "dob", required = true, value = "test dob")
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    // Constructor

    /**
     * This constructor is only for testing.
     * Parameterized constructor for Testing purposes.
     * @param login
     * @param address
     * @param items
     * @param cards
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param dob
     */
    public User(Login login,
                Address address,
                List<Item> items,
                List<Payment> cards,
                String firstName,
                String lastName,
                String email,
                String phoneNumber,
                LocalDate dob) {
        this.login = login;
        this.address = address;
        this.items = items;
        this.cards = cards;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }
}
