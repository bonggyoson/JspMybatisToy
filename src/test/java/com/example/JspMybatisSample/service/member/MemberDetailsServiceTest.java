package com.example.JspMybatisSample.service.member;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.JspMybatisSample.common.config.BaseTestConfig;
import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MemberDetailsServiceTest extends BaseTestConfig {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("로그인 테스트")
    void login_test() throws Exception {
        // given
        DummyMember dummyMember = new DummyMember();
        InsertMemberDto insertMemberDto = new InsertMemberDto(dummyMember.getMemberEmail(),
            dummyMember.getMemberPassword(), dummyMember.getMemberName());
        int result = memberMapper.insertMember(insertMemberDto);

        // when
        mockMvc.perform(formLogin("/api/member/login").user(insertMemberDto.getMemberEmail())
            .password(insertMemberDto.getMemberPassword())).andDo(print())
            .andExpect(status().is3xxRedirection());

        // then
//            .andExpect(status().is3xxRedirection())
//            .andExpect()
    }
}