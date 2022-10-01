package com.arnur.notification;

import com.arnur.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@Log4j2
public class NotificationController {

    private final NotificationService notificationService;


    @PostMapping("/")
    public void createMessage(@RequestBody NotificationRequest notificationRequest) {
        log.info("Notification created ... {}", notificationRequest);
        notificationService.createNotification(notificationRequest);
    }
}
