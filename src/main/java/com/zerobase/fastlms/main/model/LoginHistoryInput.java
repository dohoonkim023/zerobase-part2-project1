package com.zerobase.fastlms.main.model;

import com.zerobase.fastlms.main.service.LoginHistoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Data
public class LoginHistoryInput {


    long id;

    String loginId;
    LocalDateTime loginDt;
    String ip;
    String userAgent;



}
