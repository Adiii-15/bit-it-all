package com.isu.cs309.biditall.controller;

import com.isu.cs309.biditall.model.Buyer;
import com.isu.cs309.biditall.model.Login;
import com.isu.cs309.biditall.model.Seller;
import com.isu.cs309.biditall.model.User;
import com.isu.cs309.biditall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.loader.custom.NonUniqueDiscoveredSqlAliasException;
import org.javatuples.Triplet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.List;

@Api(value = "User-Rest-Controller")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     * Save user that is being requested
     */
    @ApiOperation(value = "Save the given user", response = User.class, tags = "User")
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve the User by a given ID", response = User.class, tags = "User")
    @GetMapping("{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve the user by a given username", response = User.class, tags = "User")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUserName(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve User with the highest buyer/seller rating", response = User.class, tags = "User")
    @GetMapping("highestRatings")
    public ResponseEntity<List<User>> getSellerWithHighestRating(){
        return new ResponseEntity<>(userService.sellerWithHighestRating(), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete given User by ID", response = Login.class, tags = "Login")
    @DeleteMapping("{id}")
    public void deleteUsers(@PathVariable("id") Long userId)
    {
        userService.deleteUser(userId);
    }
}