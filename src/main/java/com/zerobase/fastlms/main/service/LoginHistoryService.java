package com.zerobase.fastlms.main.service;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.admin.model.CategoryInput;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.main.dto.LoginHistoryDto;
import com.zerobase.fastlms.main.model.LoginHistoryInput;

import java.util.List;

public interface LoginHistoryService {

    /**
     * 로그인 히스토리 추가
     */

    boolean add(LoginHistoryInput parameter);

    /**
     * 로그인 히스토리 리스트 가져오기
     */
    List<LoginHistoryDto> list(String userId);
}
