package com.example.JspMybatisSample.domain.member.dto;

import com.example.JspMybatisSample.global.common.BaseEntity;
import lombok.Getter;

@Getter
public class UpdateMemberDto extends BaseEntity {

    private String memberEmail;

    private String memberName;

    private String uploadFileName;

    private String storeFileName;

    private String storePath;

    public UpdateMemberDto(String memberEmail, String memberName, String uploadFileName,
        String storeFileName, String storePath) {
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
        this.storePath = storePath;
    }

}
