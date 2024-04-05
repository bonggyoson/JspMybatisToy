//package com.example.JspMybatisSample.mapper.member;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
//
//import com.example.JspMybatisSample.common.config.BaseTestConfig;
//import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
//import com.example.JspMybatisSample.domain.member.dto.MemberDto;
//import com.example.JspMybatisSample.global.config.DatabaseConfig;
//import com.github.pagehelper.Page;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//// JUnit5 사용 시 작성, MybatisTest 2.0.1버전 이상에서 생략 가능
//// @ExtendWith(SpringExtension.class)
//// JUnit4 사용 시 작성
//// @RunWith(SpringRunner.class)
//
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@ImportAutoConfiguration(DatabaseConfig.class)
//@MybatisTest
//class MemberMapperTest extends BaseTestConfig {
//
//    @Autowired
//    private MemberMapper memberMapper;
//
//    @BeforeEach
//    public void beforeEach() {
//
//    }
//
//    @Test
//    @DisplayName("Join Member")
//    void joinMember() throws Exception {
//        // given
////        DummyMember dummyMember = new DummyMember();
////
////        InsertMemberDto insertMemberDto = new InsertMemberDto(dummyMember.getMemberEmail(),
////                dummyMember.getMemberPassword(), dummyMember.getMemberName());
////
////        // when
////        int result = memberMapper.insertMember(insertMemberDto);
//
//        // then
//        assertThat(result).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("Select Members Test")
//    void selectMembers() throws Exception {
//        // given
//        DummyMember dummyMember = new DummyMember();
//
//        InsertMemberDto insertMemberDto = new InsertMemberDto(dummyMember.getMemberEmail(),
//                dummyMember.getMemberPassword(), dummyMember.getMemberName());
//
//        memberMapper.insertMember(insertMemberDto);
//
//        // when
//        Page<MemberDto> members = memberMapper.selectMembers();
//
//        // then
//        assertThat(members);
//    }
//
//    @Test
//    @DisplayName("Select Member Using Email Test")
//    void selectMemberUsingEmail() throws Exception {
//        // Given
//        String memberEmail = "test@test.com";
//        memberMapper.insertMember(
//                new InsertMemberDto(memberEmail, "test", "test"));
//
//        // When
//        MemberDto member = memberMapper.selectMember(memberEmail);
//
//        // Then
//        assertThat(member.getMemberEmail()).isEqualTo(memberEmail);
//    }
//}
