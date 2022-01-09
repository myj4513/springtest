package com.study.webpractice.controller;

import com.study.webpractice.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, String id, String password) {

        String JSessionId = "";

        try{
            JSessionId = loginService.login(id, password);
        } catch (RuntimeException e){
            //로그인 실패시 캐치
        }

        Cookie sessionCookie = new Cookie("JSessionId", JSessionId);
        response.addCookie(sessionCookie);

        return JSessionId;
    }

    @GetMapping("/main")
    public String mainPage(HttpServletRequest request) {
        String JSessionId = "null";
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("JSessionId")) {
                JSessionId = cookie.getValue();
            }
        }

        if (loginService.isLoggedIn(JSessionId)) {
            return "redirect to login page";
        }

        return "this is main page";
    }

}
