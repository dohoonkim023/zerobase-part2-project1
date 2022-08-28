package com.zerobase.fastlms.main.service;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.entity.Category;
import com.zerobase.fastlms.admin.mapper.CategoryMapper;
import com.zerobase.fastlms.admin.model.CategoryInput;
import com.zerobase.fastlms.admin.repository.CategoryRepository;
import com.zerobase.fastlms.admin.service.CategoryService;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.main.dto.LoginHistoryDto;
import com.zerobase.fastlms.main.entity.LoginHistory;
import com.zerobase.fastlms.main.model.LoginHistoryInput;
import com.zerobase.fastlms.main.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginHistoryServiceImpl implements LoginHistoryService  {

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public boolean add(LoginHistoryInput parameter) {

        LoginHistory loginHistory = LoginHistory.builder()
                .loginId(parameter.getLoginId())
                .loginDt(parameter.getLoginDt())
                .ip(parameter.getIp())
                .userAgent(parameter.getUserAgent())
                .build();
        loginHistoryRepository.save(loginHistory);

        return true;
    }

    @Override
    public List<LoginHistoryDto> list(String userId) {
        long totalCount = loginHistoryRepository.countByLoginId(userId);
        List<LoginHistoryDto> list = LoginHistoryDto.of(loginHistoryRepository.findByLoginIdOrderByLoginDtDesc(userId));


        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (LoginHistoryDto x : list) {
                x.setSeq(totalCount - i);
                i++;
            }
        }

//        if (!optionalLoginHistory.isPresent()) {
//            throw new UsernameNotFoundException("로그인 정보가 존재하지 않습니다.");
//        }


        return list;




    }
}
