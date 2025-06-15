package com.java.practise.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.practise.constants.LoggingConstants;
import org.apache.logging.log4j.message.StringMapMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger log = LoggerFactory.getLogger(LoggerUtil.class);
    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static void serviceCallStarted(
            String endpoint) throws JsonProcessingException {
/*        log.atInfo()
                .setMessage(LoggingConstants.SERVICE_CALL_STARTED)
                .addKeyValue(LoggingConstants.ENDPOINT, endpoint)
                .log();*/

        StringMapMessage message = new StringMapMessage()
                .with("message", LoggingConstants.SERVICE_CALL_STARTED)
                .with(LoggingConstants.ENDPOINT, endpoint);
        log.info(MAPPER.writeValueAsString(message.getData()));
    }
}
