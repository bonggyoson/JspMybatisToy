package com.example.JspMybatisSample.global.common;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BaseEntity {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
