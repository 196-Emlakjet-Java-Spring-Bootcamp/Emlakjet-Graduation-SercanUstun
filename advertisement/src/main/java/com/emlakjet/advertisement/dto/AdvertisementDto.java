package com.emlakjet.advertisement.dto;

import lombok.Data;

@Data
public class AdvertisementDto {
    private String title;
    private String description;
    private long price;
    private Long userId;
}