package com.example.JspMybatisSample.domain.member;

import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.example.JspMybatisSample.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

/**
 * 사용자 도메인
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    private Long id;

    private String email;

    private String password;

    private Role role;

    @Builder
    public Member(MemberDto memberDto) {
        this.email = memberDto.getMemberEmail();
        this.password = memberDto.getMemberPassword();
        this.role = memberDto.getMemberRole();
    }

    public void updateMember(UpdateMemberDto updateMemberDto) {
        this.email = updateMemberDto.getMemberEmail();
        this.password = updateMemberDto.getMemberPassword();
    }

}
