package com.example.JspMybatisSample.domain.member;

import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.example.JspMybatisSample.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;

/**
 * 사용자 도메인
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    private Long memberId;

    private String memberEmail;

    private String memberPassword;

    private String memberName;

    private Role memberRole;

    @Builder
    public Member(MemberDto memberDto) {
        this.memberEmail = memberDto.getMemberEmail();
        this.memberPassword = memberDto.getMemberPassword();
        this.memberRole = memberDto.getMemberRole();
    }

    public void updateMember(UpdateMemberDto updateMemberDto) {
        this.memberEmail = updateMemberDto.getMemberEmail();
        this.memberPassword = updateMemberDto.getMemberPassword();
    }

}
