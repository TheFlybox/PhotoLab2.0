package com.example.photolab.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.photolab.data.api.PhotoApi;
import com.example.photolab.data.api.PhotoApiService;
import com.example.photolab.data.model.PhotoBase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository{
    private PhotoApi photoApi;
    private static PhotoRepository photoRepository;

    public static PhotoRepository getInstance(){
        if(photoRepository == null){
            photoRepository = new PhotoRepository();
        }
        return photoRepository;
    }

    public PhotoRepository(){
        photoApi = PhotoApiService.createService(PhotoApi.class);
    }

    public MutableLiveData<PhotoBase> getPhotos(String key){
        final MutableLiveData<PhotoBase> data = new MutableLiveData<>();
        photoApi.getPhotos(key).enqueue(new Callback<PhotoBase>() {
            @Override
            public void onResponse(Call<PhotoBase> call, Response<PhotoBase> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PhotoBase> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<PhotoBase> getPhotosByCategory(String category, String key) {
        final MutableLiveData<PhotoBase> data = new MutableLiveData<>();
        photoApi.getPhotosByCategory(category, key).enqueue(new Callback<PhotoBase>() {
            @Override
            public void onResponse(Call<PhotoBase> call, Response<PhotoBase> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PhotoBase> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
