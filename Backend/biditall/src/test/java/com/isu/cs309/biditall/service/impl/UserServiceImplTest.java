package com.isu.cs309.biditall.service.impl;

import com.isu.cs309.biditall.model.Address;
import com.isu.cs309.biditall.model.Login;
import com.isu.cs309.biditall.model.User;
import com.isu.cs309.biditall.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    private UserServiceImpl underTest;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @BeforeEach
    void setUp() {
        underTest = new UserServiceImpl(userRepository);
    }

    @Test
    void canAddUsers() {
        // given
        String username= "kyungPg";
        String password = passwordEncoder.encode("@~8Vup]X5vXA$W7N");

        Login login = new Login(username, password);

        Address address = new Address("first_line",
                "second_line", "Ames", "Iowa", 50012);

        LocalDate dob = LocalDate.of(2001, 3,14);

        User user = new User(login,
                address, null, null, "Kyung", "Pagano",
                "kyungp446@gmail.com", "5154145789", dob);

        // when
        underTest.saveUser(user);

        // then
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);

        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);

    }

    @Test
    @Disabled
    void getUserById() {
    }

    @Test
    @Disabled
    void getUserByUsername() {
    }
}