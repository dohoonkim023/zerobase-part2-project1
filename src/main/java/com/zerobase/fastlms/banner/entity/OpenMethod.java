package com.zerobase.fastlms.banner.entity;

import com.zerobase.fastlms.course.entity.TakeCourseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class OpenMethod implements TakeCourseCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String method;//상태(새창, 현재창 이동)
    String methodName;


}
