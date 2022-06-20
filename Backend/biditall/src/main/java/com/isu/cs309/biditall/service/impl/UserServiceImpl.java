package com.isu.cs309.biditall.service.impl;

import com.isu.cs309.biditall.exception.ResourceNotFoundException;
import com.isu.cs309.biditall.model.Login;
import com.isu.cs309.biditall.model.User;
import com.isu.cs309.biditall.repository.UserRepository;
import com.isu.cs309.biditall.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * save user to database
     */
    @Override
    public User saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getLogin().getPassword());
        user.getLogin().setPassword(encodedPassword);
        return userRepository.save(user);
    }

    /**
     * return user information based on id
     */
    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public List<User> sellerWithHighestRating() {
        return userRepository.getSellersWithHighestRating();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
