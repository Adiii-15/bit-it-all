package com.isu.cs309.biditall.service;

import com.isu.cs309.biditall.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User getUserById(Long userId);

    List<User> sellerWithHighestRating();

    User getUserByUsername(String username);

    void deleteUser(Long userId);

}
