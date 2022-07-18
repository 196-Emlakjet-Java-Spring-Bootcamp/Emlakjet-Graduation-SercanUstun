package com.emlakjet.notification.service;

import com.emlakjet.notification.dto.AdvertisementDto;
import com.emlakjet.notification.model.Notification;
import com.emlakjet.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class NotificationService {
    private final NotificationRepository notificationRepository;


    @RabbitListener(queues = "${queue.name}")
    public void listen(@Payload AdvertisementDto advertisementDto) throws InterruptedException {
        Notification notification = new Notification();
        Thread.sleep(3 * 10000);
        notification.setUserId(advertisementDto.getUserId());
        notification.setNotification("Advertisement Created Successfully");
        notificationRepository.save(notification);
    }
}
