package com.study.webpractice.service;

import com.study.webpractice.session.SessionStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    SessionStore sessionStore;

    public String login(String id, String password){

        //DB에서 데이터를 조회한 후 로그인
        //실패 시 throw new RuntimeException("로그인 실패")
        //로그인 성공한 경우
        long userId = 1;  //로그인 성공시 userId 반환

        if (sessionStore.hasUserId(userId)) {
            throw new RuntimeException("동시 접속 오류");
        }

        return sessionStore.addSession(userId);
    }

    public boolean isLoggedIn(String sessionId){
        return sessionStore.hasSession(sessionId);
    }

}
