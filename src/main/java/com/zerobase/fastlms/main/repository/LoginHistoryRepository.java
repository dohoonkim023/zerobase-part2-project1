package com.zerobase.fastlms.main.repository;

import com.zerobase.fastlms.admin.entity.Category;
import com.zerobase.fastlms.main.entity.LoginHistory;
import com.zerobase.fastlms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

    long countByLoginId(String loginID);

    List<LoginHistory> findByLoginIdOrderByLoginDtDesc(String loginId);



}
