package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.UploadFile;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.example.JspMybatisSample.global.util.FileStore;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQueryService {

    private final MemberMapper memberMapper;

    private final FileStore fileStore;

    public int insertMember(InsertMemberDto insertMemberDto) {
        return memberMapper.insertMember(insertMemberDto);
    }

    public int updateMember(long memberId, UpdateMemberDto updateMemberDto, MultipartFile file)
        throws IOException {

        UploadFile uploadFile = fileStore.storeFile(file);

        if (uploadFile == null) {
            return memberMapper.updateMember(memberId, updateMemberDto);
        } else {
            UpdateMemberDto updateMember = new UpdateMemberDto(
                updateMemberDto.getMemberEmail(),
                updateMemberDto.getMemberName(),
                uploadFile.getUploadFileName(),
                uploadFile.getStoreFileName(),
                uploadFile.getStorePath());
            return memberMapper.updateMember(memberId, updateMember);
        }
    }

    public int deleteMember(long memberId) {
        return memberMapper.deleteMember(memberId);
    }

    // 임시 비밀번호 생성
    public String createNewPassword() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    // 비밀번호 변경
    public int updateMemberPassword(long memberId, String memberPassword) {
        return memberMapper.updateMemberPassword(memberId,
            new BCryptPasswordEncoder().encode(memberPassword));
    }
}
