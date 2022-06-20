package com.isu.cs309.biditall.repository;

import com.isu.cs309.biditall.model.Address;
import com.isu.cs309.biditall.model.Item;
import com.isu.cs309.biditall.model.Login;
import com.isu.cs309.biditall.model.User;
import lombok.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository underTest;
//    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    @AfterEach
//    void tearDown() {
//        underTest.deleteAll();
//    }
//
//    @Test
//    void checkIfUserWithUsernameExists() {
//        // given
//        String username = "kyungPg";
//        String password = passwordEncoder.encode("@~8Vup]X5vXA$W7N");
//
//        Login login = new Login(username, password);
//
//        Address address = new Address("first_line",
//                "second_line", "Ames", "Iowa", 50012);
//
//        LocalDate dob = LocalDate.of(2001, 03, 14);
//
//        User user = new User(login,
//                address, null, null, "Kyung", "Pagano",
//                "kyungp446@gmail.com", "5154145789", dob);
//
//
//        // when
//        underTest.save(user);
//        User expected = underTest.findUserByUsername(username);
//
//        // then
//        assertThat(expected).isNotNull();
//        assertThat(expected).isEqualTo(user);
//
//    }
//
////    @Test
////    @Disabled
////    void checkIfUserWithUsernameDoesNotExists() {
////        // given
////        String username = "katyhlms";
////
////        // when
////        User expected = underTest.findUserByUsername(username);
////
////        // then
////        assertThat(expected).isNull();
////    }
}