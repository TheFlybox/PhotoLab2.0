package com.example.photolab.data.api;

import com.example.photolab.data.model.PhotoBase;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoApi {
    @GET(".")
    Call<PhotoBase> getPhotos(@Query("key") String key);

    @GET(".")
    Call<PhotoBase> getPhotosByCategory(@Query("category") String category, @Query("key") String key);
}
