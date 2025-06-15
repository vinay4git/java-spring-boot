package com.java.practise.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum JavaSpringBootAppErrorCodes {

    NO_USER_FOUND(1001, HttpStatus.NOT_FOUND);

    private static final Map<Integer, JavaSpringBootAppErrorCodes> errorCodeMap;

    static {
        errorCodeMap = Arrays.stream(JavaSpringBootAppErrorCodes.values()).collect(Collectors.toMap(JavaSpringBootAppErrorCodes::getErrorCode, Function.identity()));
    }

    private final Integer errorCode;
    private final HttpStatus httpStatus;

    public static JavaSpringBootAppErrorCodes getErrorByCode(Integer errorCode) {
        return errorCodeMap.get(errorCode);
    }
}
