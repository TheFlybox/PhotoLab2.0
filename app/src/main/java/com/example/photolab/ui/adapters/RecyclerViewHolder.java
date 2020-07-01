package com.example.photolab.ui.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private CardView item_cardView;
    private TextView likes, views, downloads, description;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_image);
        item_cardView = itemView.findViewById(R.id.item_cardview);
        likes = itemView.findViewById(R.id.item_likes);
        views = itemView.findViewById(R.id.item_views);
        downloads = itemView.findViewById(R.id.item_downloads);
        description = itemView.findViewById(R.id.item_description);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public CardView getItem_cardView() {
        return item_cardView;
    }

    public TextView getLikes() {
        return likes;
    }

    public TextView getViews() {
        return views;
    }

    public TextView getDownloads() {
        return downloads;
    }

    public TextView getDescription() {
        return description;
    }
}
