package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.domain.member.Role;
import com.example.JspMybatisSample.global.common.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto extends BaseEntity {

    private Long memberId;

    private String memberEmail;

    private String memberPassword;

    private String memberName;

    private Role memberRole;

    public MemberDto(Long memberId, String memberEmail, String memberPassword, String memberName,
        Role memberRole) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberRole = memberRole;
    }

}
