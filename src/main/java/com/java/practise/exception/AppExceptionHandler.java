package com.java.practise.exception;

import com.java.practise.model.ServiceResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AppExceptionHandler {


    @ExceptionHandler(JavaSpringBootAppException.class)
    @ResponseBody
    public ResponseEntity<ServiceResponse<?>> handle(JavaSpringBootAppException exception) {
        JavaSpringBootAppErrorCodes code = exception.getCode();

        ServiceResponse<?> body = ServiceResponse.builder()
                .error(Error.builder()
                        .errorCode("AP-ER-" + code.getErrorCode())
                        .errorMessage(exception.getMessage())
                        .build())
                .build();

        return ResponseEntity.status(code.getHttpStatus()).body(body);
    }
}
