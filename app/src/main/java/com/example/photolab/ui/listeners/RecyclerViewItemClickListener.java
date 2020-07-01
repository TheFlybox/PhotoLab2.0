package com.example.photolab.ui.listeners;

import android.view.View;

import com.example.photolab.data.model.Photo;

public interface RecyclerViewItemClickListener {
    void onItemClick(View element, Photo photo, int position);
}
