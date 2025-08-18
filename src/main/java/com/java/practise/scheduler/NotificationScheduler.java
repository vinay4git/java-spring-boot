package com.java.practise.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationScheduler {

    @Scheduled(fixedDelay = 1000)
    public void fixedDelayNotification() {
        System.out.println(
                "Fixed delay Notification for every Sec - " + System.currentTimeMillis() / 1000);
    }
}
