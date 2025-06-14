package com.java.practise.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsV1Response {
    private String id;
    private String name;
    private String domain;
    private String emailId;
}
