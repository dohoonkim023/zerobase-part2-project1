package com.zerobase.fastlms.main.dto;

import com.zerobase.fastlms.admin.entity.Category;
import com.zerobase.fastlms.main.entity.LoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginHistoryDto {

    private Long id;

    String loginId;
    LocalDateTime loginDt;
    String ip;
    String userAgent;

    //ADD
    long seq;



    public static List<LoginHistoryDto> of(List<LoginHistory> histories) {
        if (histories != null) {
            List<LoginHistoryDto> historyList = new ArrayList<>();
            for (LoginHistory x : histories) {
                historyList.add(of(x));
            }
            return historyList;
        }

        return null;
    }

    public static LoginHistoryDto of(LoginHistory history) {
        return LoginHistoryDto.builder()
                .id(history.getId())
                .loginId(history.getLoginId())
                .loginDt(history.getLoginDt())
                .ip(history.getIp())
                .userAgent(history.getUserAgent())
                .build();
    }



    public String getLoginDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return loginDt != null ? loginDt.format(formatter) : "";

    }
}
