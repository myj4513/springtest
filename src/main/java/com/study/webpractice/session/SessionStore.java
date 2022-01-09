package com.study.webpractice.session;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionStore {

    Map<String, SessionData> sessionStore = new ConcurrentHashMap<>();

    public Map getSessionStore(){
        return this.sessionStore;
    }

    public boolean hasUserId(long userId){
        for (SessionData sessionData : sessionStore.values()) {
            if (sessionData.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSession(String sessionId){
        return sessionStore.get(sessionId)!=null;
    }

    public String addSession(long userId){
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, SessionData.of(userId));
        return sessionId;
    }

    public void expireSession(String sessionId){
        sessionStore.remove(sessionId);
    }
}
