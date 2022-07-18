package com.emlakjet.user.retrofit.service;

import com.emlakjet.user.retrofit.request.IAdvertisementServiceRequest;
import com.emlakjet.user.retrofit.util.RetrofitUtils;
import com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sa
 * @date 18.04.2021
 * @time 14:08
 */
@Slf4j
@Service
public class AdvertisementService {

    @Autowired
    private IAdvertisementServiceRequest advertisementServiceRequest;

    public JsonElement saveAdvertisement(JsonElement requestBody) {
        return RetrofitUtils.executeInBlock(advertisementServiceRequest.saveAdvertisement(requestBody));
    }

    public void deleteAdverisementById(Long productId) {
        RetrofitUtils.executeInBlock(advertisementServiceRequest.deleteAdvertisementbyId(productId));
    }

    public List<JsonElement> findAllAdvertisements() {
        return RetrofitUtils.executeInBlock(advertisementServiceRequest.findAllAdvertisements());
    }
}
