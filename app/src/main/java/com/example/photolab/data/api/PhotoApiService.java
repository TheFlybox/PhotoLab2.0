package com.example.photolab.data.api;

import com.example.photolab.helpers.Helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoApiService {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Helpers.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
