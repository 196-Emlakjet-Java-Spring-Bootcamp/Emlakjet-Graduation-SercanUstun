package com.emlakjet.user.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IAdvertisementServiceRequest {
    @POST("/api/advertisements")
    Call<JsonElement> saveAdvertisement(@Body JsonElement requestBody);

    @DELETE("/api/advertisements/{id}")
    Call<Void> deleteAdvertisementbyId(@Path("id") Long id);

    @GET("/api/advertisements")
    Call<List<JsonElement>> findAllAdvertisements();
}
