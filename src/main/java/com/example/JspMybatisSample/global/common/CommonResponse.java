package com.example.JspMybatisSample.global.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

    private HttpStatus status;
    private String message;
    private T data;

    public CommonResponse(final HttpStatus status, final String message) {
        this.status = status;
        this.message = message;
    }

    public static <T> CommonResponse<T> res(final HttpStatus status, final String message) {
        return res(status, message, null);
    }

    public static <T> CommonResponse<T> res(final HttpStatus status, final String message,
        final T t) {
        return CommonResponse.<T>builder()
            .status(status)
            .message(message)
            .data(t)
            .build();
    }
}