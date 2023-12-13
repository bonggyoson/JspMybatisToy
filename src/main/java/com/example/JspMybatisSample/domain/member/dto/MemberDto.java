package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.domain.member.Role;
import com.example.JspMybatisSample.global.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto extends BaseEntity {

    private Long memberId;

    private String memberEmail;

    private String memberPassword;

    private Role memberRole;

}
