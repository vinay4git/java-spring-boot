package com.java.practise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.practise.constants.ApplicationConstants;
import com.java.practise.model.ServiceResponse;
import com.java.practise.model.UserDetailsV1Response;
import com.java.practise.service.UseV1Service;
import com.java.practise.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserV1Controller {

    @Autowired private UseV1Service useV1Service;

    @GetMapping(path = "/details", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServiceResponse<?>> getUserDetails(@RequestParam("id") String id) throws JsonProcessingException {
        String endpoint = ApplicationConstants.GET_USER_DETAILS_ENDPOINT;
        LoggerUtil.serviceCallStarted(endpoint);
        UserDetailsV1Response user = useV1Service.getUser(id);
        ServiceResponse<UserDetailsV1Response> serviceResponse = ServiceResponse.<UserDetailsV1Response>builder().payload(user).build();
        return ResponseEntity.ok().body(serviceResponse);
    }
}
