package com.example.photolab.ui.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.photolab.data.api.PhotoApiService;
import com.example.photolab.data.model.PhotoBase;
import com.example.photolab.data.repository.PhotoRepository;
import com.example.photolab.helpers.Helpers;

public class PhotoViewModel extends ViewModel {
    private MutableLiveData<PhotoBase> photos;
    private PhotoRepository photoRepository;

    public PhotoViewModel(){
        photoRepository = PhotoRepository.getInstance();
        photos = photoRepository.getPhotos(Helpers.API_KEY);
    }

    public LiveData<PhotoBase> getPhotos(){
        return photos;
    }
    public LiveData<PhotoBase> getPhotosByCategory(String category){
        return photoRepository.getPhotosByCategory(category, Helpers.API_KEY);
    }
}
