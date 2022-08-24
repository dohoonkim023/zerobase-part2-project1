package com.zerobase.fastlms.course.repository;

import com.zerobase.fastlms.course.entity.Course;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.time.LocalDateTime;


public interface CourseRepository extends JpaRepository<Course, Long> {




}
