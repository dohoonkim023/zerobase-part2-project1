package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.entity.OpenMethod;
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
public class OpenMethodDto {


    Long id;

    String method;
    String methodName;


    public static OpenMethodDto of(OpenMethod openMethod) {
        return OpenMethodDto.builder()
                .id(openMethod.getId())
                .method(openMethod.getMethod())
                .methodName(openMethod.getMethodName())
                .build();
    }

    public static List<OpenMethodDto> of(List<OpenMethod> openMethods) {

        if (openMethods == null) {
            return null;
        }

        List<OpenMethodDto> methodList = new ArrayList<>();
        for(OpenMethod x : openMethods) {
            methodList.add(OpenMethodDto.of(x));
        }
        return methodList;

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
