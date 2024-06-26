package com.example.JspMybatisSample.api.controller.member;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.JspMybatisSample.common.config.BaseControllerTestConfig;
import com.example.JspMybatisSample.service.member.MemberCommandService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

public class MemberApiControllerTest extends BaseControllerTestConfig {

    @Test
    @WithMockUser
    void select_member_test() throws Exception {
        // given

        // when

        // then
        mockMvc.perform(post("/api/member").with(csrf()))
            .andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    @DisplayName("Mock 테스트")
    void testSimple() {
        List<String> mockList = Mockito.mock(List.class);

        Mockito.when(mockList.size()).thenReturn(5);
        System.out.println("동작 값 확인 :: " + mockList.size());

        Mockito.verify(mockList).size();
    }
}
