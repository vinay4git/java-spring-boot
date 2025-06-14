package com.java.practise.exception;

import lombok.Getter;

@Getter
public class JavaSpringBootAppException extends RuntimeException {
    private final JavaSpringBootAppErrorCodes code;
    private final String message;

    public JavaSpringBootAppException(JavaSpringBootAppErrorCodes code, String message) {
        this.code = code;
        this.message = message;
    }
}
