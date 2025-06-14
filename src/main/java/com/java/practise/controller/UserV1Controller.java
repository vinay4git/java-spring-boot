package com.java.practise.controller;

import com.java.practise.database.dao.User;
import com.java.practise.service.UseV1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserV1Controller {

    @Autowired private UseV1Service useV1Service;

    @GetMapping("/details")
    public User getUserDetails(@RequestParam("id") String id) {
        return useV1Service.getUser(id);
    }
}
