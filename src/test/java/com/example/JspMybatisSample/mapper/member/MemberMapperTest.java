package com.example.JspMybatisSample.mapper.member;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;

import com.example.JspMybatisSample.common.config.BaseTestConfig;
import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithPasswordDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithoutPasswordDto;
import com.example.JspMybatisSample.global.config.DatabaseConfig;
import com.example.JspMybatisSample.global.config.JasyptConfig;
import com.github.pagehelper.Page;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

// JUnit5 사용 시 작성, MybatisTest 2.0.1버전 이상에서 생략 가능
// @ExtendWith(SpringExtension.class)
// JUnit4 사용 시 작성
// @RunWith(SpringRunner.class)

@MybatisTest
@AutoConfigureTestDatabase(replace = NONE)
@ImportAutoConfiguration(DatabaseConfig.class)
class MemberMapperTest extends BaseTestConfig {

    @Autowired
    private MemberMapper memberMapper;

    @BeforeEach
    public void beforeEach() {

    }

    @Test
    @DisplayName("Join Member")
    void joinMember() throws Exception {
        // given
        DummyMember dummyMember = new DummyMember();

        InsertMemberDto insertMemberDto = new InsertMemberDto(dummyMember.getMemberEmail(),
            dummyMember.getMemberPassword(), dummyMember.getMemberName());

        // when
        int result = memberMapper.insertMember(insertMemberDto);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Select Members")
    void selectMembers() throws Exception {
        // given
        DummyMember dummyMember = new DummyMember();

        InsertMemberDto insertMemberDto = new InsertMemberDto(dummyMember.getMemberEmail(),
            dummyMember.getMemberPassword(), dummyMember.getMemberName());

        memberMapper.insertMember(insertMemberDto);

        // when
        Page<MemberWithoutPasswordDto> members = memberMapper.selectMembers();

        // then
        assertThat(members).anySatisfy(member -> {
            assertThat(member.getMemberEmail()).isEqualTo(dummyMember.getMemberEmail());
        });
    }

    @Test
    @DisplayName("Select Member Using Email Test")
    void selectMemberUsingEmail() throws Exception {
        // Given
        String memberEmail = new DummyMember().getMemberEmail();
        memberMapper.insertMember(
            new InsertMemberDto(memberEmail, "test", "test"));

        // When
        MemberWithPasswordDto member = memberMapper.selectMember(memberEmail);

        // Then
        assertThat(member.getMemberEmail()).isEqualTo(memberEmail);
    }

    @Test
    @DisplayName("Test FixtureMonkey")
    void testFixtureMonkey() {
        // given
        InsertMemberDto member = monkey().giveMeOne(InsertMemberDto.class);

        // when
        memberMapper.insertMember(
            new InsertMemberDto(member.getMemberEmail(), member.getMemberPassword(),
                member.getMemberName()));

        //then
        assertThat(member.getMemberEmail()).isEqualTo(
            memberMapper.selectMember(member.getMemberEmail()).getMemberEmail());

    }
}
