package com.java.practise.service;

import com.java.practise.database.dao.User;
import com.java.practise.database.respositories.UserRepository;
import com.java.practise.model.UserDetailsV1Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


class UserV1ServiceTest {

    @InjectMocks
    UserV1Service userV1Service;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setupBeforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUserGet() {
        Mockito.when(userRepository.findById(String.valueOf(Mockito.anyInt()))).thenReturn(Optional.of(User.builder().name("Vinay").build()));

        UserDetailsV1Response user = userV1Service.getUser(String.valueOf(124));

        Assertions.assertEquals("Vinay", user.getName());
    }

}