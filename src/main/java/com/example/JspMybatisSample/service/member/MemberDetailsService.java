package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.Member;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDto memberDto = memberMapper.selectMember(username);
        Member member = Member.builder()
            .memberId(memberDto.getMemberId())
            .memberEmail(memberDto.getMemberEmail())
//            .memberPassword(memberDto.getMem)
            .build();
        if (member == null) {
            throw new UsernameNotFoundException(username + " 회원이 존재하지 않습니다.");
        }
        return member;
    }
}
