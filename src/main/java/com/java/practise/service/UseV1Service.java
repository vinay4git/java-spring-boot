package com.java.practise.service;

import com.java.practise.database.dao.User;
import com.java.practise.database.respositories.UserRepository;
import com.java.practise.exception.JavaSpringBootAppErrorCodes;
import com.java.practise.exception.JavaSpringBootAppException;
import com.java.practise.model.UserDetailsV1Response;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UseV1Service {

    private static final Logger log = LoggerFactory.getLogger(UseV1Service.class);
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {
        User userVinay = User.builder().name("Vinay")
                .emailId("abv@gmail.com")
                .id("123")
                .domain("it")
                .build();

        User userKumar = User.builder().name("Kumar")
                .emailId("kum@gmail.com")
                .id("2332")
                .domain("civil")
                .build();

        userRepository.saveAll(List.of(userVinay, userKumar));
    }

    public UserDetailsV1Response getUser(String id) {
        return userRepository.findById(id)
                .map(user -> UserDetailsV1Response.builder()
                        .id(user.getId())
                        .domain(user.getDomain())
                        .emailId(user.getEmailId())
                        .name(user.getName())
                        .build())
                .orElseThrow(() -> {
                    log.error("No Element found for user id: {}", id);
                    return new JavaSpringBootAppException(JavaSpringBootAppErrorCodes.NO_USER_FOUND, "No user found with given Id.");
                });
    }

}
