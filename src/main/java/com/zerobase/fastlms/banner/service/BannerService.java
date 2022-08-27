package com.zerobase.fastlms.banner.service;


import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.dto.OpenMethodDto;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.model.TakeCourseInput;

import java.util.List;

public interface BannerService {

    /**
     * 강좌 등록
     */
    boolean add(BannerInput parameter);


    /**
     * 강좌 정보 수정
     */
    boolean set(BannerInput parameter);

    /**
     * 배너 목록
     */

    List<BannerDto> list(BannerParam parameter);


    /**
     * 배너 상태 정보
     */
    BannerDto getById(long id);

    /**
     * 오픈 방법 목록
     * @return
     */
    List<OpenMethodDto> methodList();

    /**
     * 배너 삭제
     */
    boolean del(String idList);

    List<BannerDto> frontList();

//    /**
//     * 프론트 강좌 목록
//     */
//    List<CourseDto> frontList(CourseParam parameter);
//
//    /**
//     * 프론트 강좌 상세 정보
//     */
//    CourseDto frontDetail(long id);
//
//    /**
//     * 수강 신청
//     */
//    ServiceResult req(TakeCourseInput parameter);
//
//    /**
//     * 전체 강좌 목록
//     */
//    List<CourseDto> listAll();
}
