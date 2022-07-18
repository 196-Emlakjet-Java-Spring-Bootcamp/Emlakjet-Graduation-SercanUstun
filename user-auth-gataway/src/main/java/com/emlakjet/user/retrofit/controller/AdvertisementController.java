package com.emlakjet.user.retrofit.controller;

import com.emlakjet.user.retrofit.service.AdvertisementService;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/advertisements")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping
    public ResponseEntity<?> saveAdvertisement(@RequestBody JsonElement advertisement) {
        return ResponseEntity.ok(advertisementService.saveAdvertisement(advertisement));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdverisementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAllAdvertisements() {
        return ResponseEntity.ok(advertisementService.findAllAdvertisements());
    }
}
