package com.example.JspMybatisSample.controller.member.api;

import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithoutPasswordDto;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.global.util.FileStore;
import com.example.JspMybatisSample.global.util.MailService;
import com.example.JspMybatisSample.service.member.MemberCommandService;
import com.example.JspMybatisSample.service.member.MemberQueryService;
import com.github.pagehelper.PageInfo;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberApiController {

    private final MemberQueryService memberQueryService;

    private final MemberCommandService memberCommandService;

    private final MailService mailService;

    private final FileStore fileStore;

    @PostMapping("/join")
    public ResponseEntity<CommonResponse<?>> join(
        @Valid @RequestBody final InsertMemberDto insertMemberDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CommonResponse.res("회원 가입 성공",
                memberQueryService.insertMember(insertMemberDto)));
    }

    @PostMapping("/checkDuplicateEmail")
    public int checkDuplicateEmail(@RequestParam String memberEmail) {

        return memberCommandService.checkDuplicateEmail(memberEmail);
    }

    @PostMapping("")
    public ResponseEntity<CommonResponse<?>> selectMembers(
        @RequestParam(required = false, defaultValue = "1") int page) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res("회원 조회 성공",
                new PageInfo<>(memberCommandService.selectMembers(page))));
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<CommonResponse<?>> selectMember(@PathVariable long memberId) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res("회원 상세 조회 성공",
                memberCommandService.selectMember(memberId)));
    }

    @PutMapping("/{memberId}/update")
    public ResponseEntity<CommonResponse<?>> updateMember(@PathVariable long memberId,
        @Valid @RequestPart(value = "data") UpdateMemberDto updateMemberDto,
        @RequestPart(value = "img", required = false) MultipartFile file) throws IOException {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res("회원 수정 성공",
                memberQueryService.updateMember(memberId, updateMemberDto, file)));
    }

    @PostMapping("/{memberId}/updatePassword")
    public ResponseEntity<CommonResponse<?>> updateMemberPassword(@PathVariable long memberId,
        @RequestBody String memberPassword) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res("비밀번호 수정 성공",
                memberQueryService.updateMemberPassword(memberId, memberPassword)));
    }

    @DeleteMapping("/{memberId}/delete")
    public ResponseEntity<CommonResponse<?>> deleteMember(@PathVariable long memberId,
        HttpSession httpSession) {

        httpSession.invalidate();

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(CommonResponse.res("회원 삭제 성공",
                memberQueryService.deleteMember(memberId)));
    }

    // TODO: 2024-02-28 - 이메일 인증 방식 구현
    @PostMapping("/resetPassword")
    public ResponseEntity<CommonResponse<?>> resetPassword(
        @RequestBody MemberWithoutPasswordDto memberDto) {

        mailService.sendSimpleMessage(memberDto.getMemberEmail(), "[ToyProject] 임시 비밀번호입니다.",
            memberQueryService.createNewPassword());

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(CommonResponse.res("비밀번호 재설정 성공"));
    }

    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {

        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }
}
