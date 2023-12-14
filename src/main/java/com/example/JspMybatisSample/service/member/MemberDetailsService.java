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
        Member member = new Member(memberMapper.selectMember(username));
        if (member != null) {
            return (UserDetails) member;
        }
        return null;
    }
}
