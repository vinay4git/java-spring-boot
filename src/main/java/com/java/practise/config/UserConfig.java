package com.java.practise.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "app.user")
@Getter
@Component
@Setter // setter is needed for the list to build from the properties file.
public class UserConfig {
    private Integer maxNameLength;
    private List<String> domainsAllowed;
}
