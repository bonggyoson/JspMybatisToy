package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.domain.member.Role;
import lombok.Getter;

@Getter
public class InsertMemberDto {

    private String memberEmail;

    private String memberPassword;

    private String memberName;

    private Role memberRole;

    public InsertMemberDto(String memberEmail, String memberPassword, String memberName) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberRole = Role.ROLE_MEMBER;
    }
}
