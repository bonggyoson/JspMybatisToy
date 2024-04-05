package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.Member;
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
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {

        Member member = Member.builder()
            .memberEmail(memberMapper.selectMember(memberEmail).getMemberEmail())
            .memberPassword(memberMapper.selectMember(memberEmail).getMemberPassword())
        .build();

        if (member == null) {
            throw new UsernameNotFoundException(memberEmail + " 회원이 존재하지 않습니다.");
        }
        return member;
    }
}
