package com.emlakjet.advertisement.repository;


import com.emlakjet.advertisement.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
