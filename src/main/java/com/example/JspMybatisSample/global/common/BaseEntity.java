package com.example.JspMybatisSample.global.common;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntity {

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;
}
