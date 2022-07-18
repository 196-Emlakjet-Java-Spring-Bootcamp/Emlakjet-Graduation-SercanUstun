package com.emlakjet.notification.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdvertisementDto {

    private String title;
    private String description;
    private long price;
    private LocalDateTime createdAt;
    private Long userId;


}
