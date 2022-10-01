package com.arnur.notification;

import com.arnur.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;


    public void createNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("Amigoscode")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build());
    }
}
