package com.example.JspMybatisSample.domain.member;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 사용자 도메인
 */
@Getter
public class Member {

    private Long id;

    private String email;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Role role;

}
