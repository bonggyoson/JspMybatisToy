package com.example.JspMybatisSample.global.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse<T> {

    private String message;
    private T data;

    public ErrorResponse(final String message) {
        this.message = message;
    }

    public static <T> ErrorResponse<T> res(final String message) {
        return res(message, null);
    }

    public static <T> ErrorResponse<T> res(final String message,
        final T t) {
        return ErrorResponse.<T>builder()
            .message(message)
            .data(t)
            .build();
    }
}