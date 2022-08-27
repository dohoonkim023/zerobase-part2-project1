package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BannerDto {


    Long id;

    String bannerName;
    String link;
    String openMethod;
    long sortValue;
    Boolean disclosureYn;

    LocalDateTime regDt;//등록일(추가날짜)
    LocalDateTime udtDt;//수정일(수정날짜)


    String filename;
    String urlFilename;

    //추가컬럼
    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .link(banner.getLink())
                .openMethod(banner.getOpenMethod())
                .sortValue(banner.getSortValue())
                .disclosureYn(banner.getDisclosureYn())
                .regDt(banner.getRegDt())
                .udtDt(banner.getUdtDt())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> courseList = new ArrayList<>();
        for(Banner x : banners) {
            courseList.add(BannerDto.of(x));
        }
        return courseList;

        /*
        if (courses != null) {
            List<CourseDto> courseList = new ArrayList<>();
            for(Course x : courses) {
                courseList.add(CourseDto.of(x));
            }
            return courseList;
        }
        return null;
        */

    }


}
