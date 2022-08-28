package com.zerobase.fastlms.configurations;

import com.zerobase.fastlms.main.model.LoginHistoryInput;
import com.zerobase.fastlms.main.service.LoginHistoryService;
import com.zerobase.fastlms.main.service.LoginHistoryServiceImpl;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@ToString
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final LoginHistoryService loginHistoryService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;

        String id = ((UserDetails) principal).getUsername();
        String userAgent = RequestUtils.getUserAgent(request);
        String clientIp = RequestUtils.getClientIp(request);

        LoginHistoryInput historyInput = new LoginHistoryInput();
        historyInput.setLoginId(id);
        historyInput.setLoginDt(LocalDateTime.now());
        historyInput.setIp(clientIp);
        historyInput.setUserAgent(userAgent);

        loginHistoryService.add(historyInput);
        //System.out.println("test222 : " + historyInput.toString());


        super.onAuthenticationSuccess(request, response, authentication);
    }

    //    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//
//        String msg = "로그인에 실패하였습니다.";
//
//        if (exception instanceof InternalAuthenticationServiceException) {
//            msg = exception.getMessage();
//        }
//
//        setUseForward(true);
//        setDefaultFailureUrl("/member/login?error=true");
//        request.setAttribute("errorMessage", msg);
//
//        super.onAuthenticationSuccess(request, response, exception);
//    }
}
