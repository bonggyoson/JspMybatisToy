package com.example.JspMybatisSample.domain.member;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("관리자"),
    ROLE_MEMBER("회원");

    final String role;

    Role(String role) {
        this.role = role;
    }

    public String value() {
        return role;
    }
}
