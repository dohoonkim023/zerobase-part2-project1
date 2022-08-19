package com.zerobase.fastlms.main.controller;

import com.zerobase.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index() {

        String email = "lms.testing.02@gmail.com";
        String subject = "안녕하세요. 제로베이스 입니다.";
        String text = "<p>안녕하세요.</p> <p>반갑습니다.</p>";

        //mailComponents.sendMail(email, subject, text);

        return "index";
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
