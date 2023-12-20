package com.example.JspMybatisSample.global.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

    private String message;
    private T data;

    public CommonResponse(final String message) {
        this.message = message;
    }

    public static <T> CommonResponse<T> res(final String message) {
        return res(message, null);
    }

    public static <T> CommonResponse<T> res(final String message,
        final T t) {
        return CommonResponse.<T>builder()
            .message(message)
            .data(t)
            .build();
    }
}