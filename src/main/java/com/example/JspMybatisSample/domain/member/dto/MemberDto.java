package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.domain.member.Role;
import com.example.JspMybatisSample.global.common.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberDto {

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberWithPasswordDto extends BaseEntity {

        private Long memberId;

        private String memberEmail;

        private String memberPassword;

        private String memberName;

        private Role memberRole;

    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberWithoutPasswordDto extends BaseEntity {

        private Long memberId;

        private String memberEmail;

        private String memberName;

        private Role memberRole;
        
    }

}
