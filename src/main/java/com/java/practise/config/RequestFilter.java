package com.java.practise.config;

import com.java.practise.constants.ApplicationConstants;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String request_tracking_id = request.getHeader(ApplicationConstants.REQUEST_TRACKING_ID);
        MDC.put(ApplicationConstants.REQUEST_TRACKING_ID, request_tracking_id);

        try {
            filterChain.doFilter(request, response);
        } finally {
            //log.info("MDC contest removed for tracking Id : {}", MDC.get(ApplicationConstants.REQUEST_TRACKING_ID));
            MDC.remove(ApplicationConstants.REQUEST_TRACKING_ID);
        }
    }
}
