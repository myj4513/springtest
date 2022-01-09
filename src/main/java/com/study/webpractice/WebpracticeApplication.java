package com.study.webpractice;

import com.study.webpractice.session.SessionData;
import com.study.webpractice.session.SessionStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class WebpracticeApplication {
    @Autowired
    static SessionStore sessionStore;

    public static void main(String[] args) {

        SpringApplication.run(WebpracticeApplication.class, args);

        Runnable expireSession = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" saids hi");

//                Map<String, SessionData> sessionMap = sessionStore.getSessionStore();
//
//                System.out.println(sessionMap);
//                Set<Map.Entry<String, SessionData>> entrySet = sessionMap.entrySet();
//                for (Map.Entry<String, SessionData> entry : entrySet) {
//                    if (entry.getValue().getExpireTime().isAfter(LocalDateTime.now())) {
//                        sessionStore.expireSession(entry.getKey());
//                        System.out.println("expired session, " + entry.getKey());
//                    }
//                }
//                System.out.println("hi");
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleWithFixedDelay(expireSession, 0, 1, TimeUnit.SECONDS);

    }

}
