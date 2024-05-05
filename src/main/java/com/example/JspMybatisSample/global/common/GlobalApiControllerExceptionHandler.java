package com.example.JspMybatisSample.global.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalApiControllerExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, NullPointerException.class})
    public ResponseEntity<CommonResponse<ErrorResponse<?>>> handleValidationException(
        MethodArgumentNotValidException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(CommonResponse.res(exception.getMessage()));
    }
}
