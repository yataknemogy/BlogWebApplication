package com.example.blogwebapplication;

import com.example.blogwebapplication.model.User;
import com.example.blogwebapplication.repository.UserRepository;
import com.example.blogwebapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void getUserById_ExistingId_ReturnsUser() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserService userService = new UserService(userRepository);

        User result = userService.getUserById(userId);

        assertEquals(user, result);
    }

}
