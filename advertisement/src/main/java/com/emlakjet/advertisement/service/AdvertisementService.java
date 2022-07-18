package com.emlakjet.advertisement.service;


import com.emlakjet.advertisement.dto.AdvertisementDto;
import com.emlakjet.advertisement.model.Advertisement;
import com.emlakjet.advertisement.repository.AdvertisementRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;


    public Advertisement saveAdvertisement(AdvertisementDto advertisementDto) {

        Advertisement advertisement = Advertisement.builder()
                .title(advertisementDto.getTitle())
                .description(advertisementDto.getDescription())
                .price(advertisementDto.getPrice())
                .createdAt(LocalDateTime.now())
                .userId(advertisementDto.getUserId())
                .build();
        rabbitTemplate.convertAndSend(queue.getName(), advertisementDto);
        return advertisementRepository.save(advertisement);
    }

    public void deleteAdvertisementbyId(Long id) {
        advertisementRepository.deleteById(id);
    }

    public List<Advertisement> findAllAdvertisements() {
        return advertisementRepository.findAll();
    }


}
