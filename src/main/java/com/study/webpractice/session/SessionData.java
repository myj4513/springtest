package com.study.webpractice.session;

import java.time.LocalDateTime;

public class SessionData {
    private Long userId;
    private LocalDateTime expireTime;

    private SessionData(Long userId) {
        this.userId = userId;
        this.expireTime = LocalDateTime.now().plusSeconds(30);
    }

    public static SessionData of(long userId){
        return new SessionData(userId);
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }
}
