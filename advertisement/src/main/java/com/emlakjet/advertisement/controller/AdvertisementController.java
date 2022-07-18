package com.emlakjet.advertisement.controller;

import com.emlakjet.advertisement.dto.AdvertisementDto;
import com.emlakjet.advertisement.service.AdvertisementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/advertisements")
@AllArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;


    @GetMapping
    public ResponseEntity<?> findAllAdvertisements() {
        return ResponseEntity.ok(advertisementService.findAllAdvertisements());
    }


    @PostMapping
    public ResponseEntity<?> saveAdvertisement(@RequestBody AdvertisementDto advertisement) {
        return new ResponseEntity<>(advertisementService.saveAdvertisement(advertisement), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdverisementById(@PathVariable("id") long id) {
        advertisementService.deleteAdvertisementbyId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
