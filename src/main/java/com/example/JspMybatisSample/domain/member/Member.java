package com.example.JspMybatisSample.domain.member;

import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithPasswordDto;
import com.example.JspMybatisSample.global.common.BaseEntity;
import java.util.Collection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 사용자 도메인
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity implements UserDetails {

    private Long memberId;

    private String memberEmail;

    private String memberPassword;

    private String memberName;

    private Role memberRole;

    private String uploadFileName;

    private String storeFileName;

    private String storePath;

    @Builder
    public Member(MemberWithPasswordDto memberDto) {
        this.memberId = memberDto.getMemberId();
        this.memberEmail = memberDto.getMemberEmail();
        this.memberPassword = memberDto.getMemberPassword();
        this.memberName = memberDto.getMemberName();
        this.memberRole = memberDto.getMemberRole();
        this.uploadFileName = memberDto.getUploadFileName();
        this.storeFileName = memberDto.getStoreFileName();
        this.storePath = memberDto.getStorePath();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.memberPassword;
    }

    @Override
    public String getUsername() {
        return this.getMemberEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
