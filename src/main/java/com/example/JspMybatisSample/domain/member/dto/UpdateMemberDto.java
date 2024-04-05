package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.global.common.BaseEntity;
import lombok.Getter;

@Getter
public class UpdateMemberDto extends BaseEntity {

    private String memberEmail;

    private String memberName;

    public UpdateMemberDto(String memberEmail, String memberName) {
        this.memberEmail = memberEmail;
        this.memberName = memberName;
    }

}
