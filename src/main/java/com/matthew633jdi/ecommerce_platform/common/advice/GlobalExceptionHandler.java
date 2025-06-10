package com.matthew633jdi.ecommerce_platform.common.advice;

import com.matthew633jdi.ecommerce_platform.common.dto.ErrorResponse;
import com.matthew633jdi.ecommerce_platform.common.exception.AlreadyExistsEmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyExistsEmailException.class)
    public ErrorResponse handleAlreadyExistsEmailException(AlreadyExistsEmailException ex) {
        return ErrorResponse.of(ex.getMessage());
    }
}
