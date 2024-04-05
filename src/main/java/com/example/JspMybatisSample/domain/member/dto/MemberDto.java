package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.domain.member.Member;
import com.example.JspMybatisSample.domain.member.Role;
import com.example.JspMybatisSample.global.common.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto extends BaseEntity {

    private Long memberId;

    private String memberEmail;

    private String memberName;

    private Role memberRole;

    @Builder
    public MemberDto(Long memberId, String memberEmail, String memberName, Role memberRole) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.memberRole = memberRole;
    }

    public static MemberDto entityToDto(Member member) {
        return MemberDto.builder()
            .memberId(member.getMemberId())
            .memberEmail(member.getMemberEmail())
            .memberName(member.getMemberName())
            .memberRole(member.getMemberRole())
            .build();
    }

}
