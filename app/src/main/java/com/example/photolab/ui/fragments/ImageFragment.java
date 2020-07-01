package com.example.photolab.ui.fragments;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.R;
import com.example.photolab.data.model.Photo;
import com.example.photolab.ui.EntryActivity;
import com.example.photolab.ui.adapters.RecyclerViewAdapter;
import com.example.photolab.ui.viewModels.PhotoViewModel;

import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends BaseFragment {
    private String title;
    private PhotoViewModel model;
    private RecyclerView photos_recyclerview;

    public ImageFragment(String title){
        this.title = title;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public String getFragmentTitle() {
        return this.title;
    }

    @Override
    public void setup() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext());
        adapter.setOnItemClickListener((element, photo, position) -> {
            List<String> data = new ArrayList<>();
            if(adapter.getmData() != null){
                for(Photo item : adapter.getmData()){
                    data.add(item.getLargeImageURL());
                }
            }
            EntryActivity.loadFragment(new PreviewFragment(data, position), getCompatActivity());
        });

        photos_recyclerview = getView().findViewById(R.id.photos_recyclerview);
        photos_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        photos_recyclerview.setAdapter(adapter);

        model = new ViewModelProvider(this).get(PhotoViewModel.class);

        // Observe data
        model.getPhotosByCategory(this.title).observe(this, photos -> {
            adapter.setmData(photos.getHits());
        });
    }
}
