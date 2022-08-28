package com.zerobase.fastlms.main.entity;

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
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String loginId;
    LocalDateTime loginDt;
    String ip;
    String userAgent;


}
