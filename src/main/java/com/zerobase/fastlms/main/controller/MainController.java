package com.zerobase.fastlms.main.controller;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.service.BannerService;
import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.main.model.LoginHistoryInput;
import com.zerobase.fastlms.main.service.LoginHistoryService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.util.SpringRequestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;
    private final BannerService bannerService;
    private final LoginHistoryService loginHistoryService;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request
            , Principal principal) {

        String email = "lms.testing.02@gmail.com";
        String subject = "안녕하세요. 제로베이스 입니다.";
        String text = "<p>안녕하세요.</p> <p>반갑습니다.</p>";

        //mailComponents.sendMail(email, subject, text);

        List<BannerDto> bannerList = bannerService.frontList();
        model.addAttribute("bannerList", bannerList);

        //회원 로그인시 로그인 히스토리(로그) 기능
//        String userAgent = RequestUtils.getUserAgent(request);
//        String clientIp = RequestUtils.getClientIp(request);
//
//        String id = principal.getName();
//
//        LoginHistoryInput historyInput = new LoginHistoryInput();
//        historyInput.setLoginId(id);
//        historyInput.setLoginDt(LocalDateTime.now());
//        historyInput.setIp(clientIp);
//        historyInput.setUserAgent(userAgent);
//
//        boolean result = loginHistoryService.add(historyInput);

        return "index";
    }


    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }



    // request -> WEB -> SERVER
    // response -> SERVER -> WEB
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<p> hello yee 잖아</p>" +
                "</html>";

        printWriter.write(msg);
        printWriter.close();
    }





}
