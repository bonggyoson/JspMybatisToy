package com.example.JspMybatisSample.global.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalApiControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
        MethodArgumentNotValidException e) {

        log.error("MethodArgumentNotValidException", e.getMessage());

        final ErrorResponse res = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE,
            e.getBindingResult());

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
        IllegalArgumentException e) {

        log.error("IllegalArgumentException", e.getMessage());

        final ErrorResponse res = ErrorResponse.of(ErrorCode.ILLEGAL_ARGUMENT,
            e.getMessage());

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
