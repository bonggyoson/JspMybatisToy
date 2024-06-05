package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.domain.member.Role;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class InsertMemberDto {

    @NotNull(message = "이메일을 입력해 주세요.")
    private String memberEmail;

    @NotNull(message = "비밀번호를 입력해 주세요.")
    private String memberPassword;

    @NotNull(message = "이름을 입력해 주세요.")
    private String memberName;

    private Role memberRole;

    public InsertMemberDto(String memberEmail, String memberPassword, String memberName) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberRole = Role.ROLE_MEMBER;
    }
}
