package com.example.photolab.ui.adapters;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.R;

public class ViewPager2AdapterViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    public ViewPager2AdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.the_image);
    }
    public ImageView getImageView() {
        return imageView;
    }
}
