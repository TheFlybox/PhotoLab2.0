package com.example.photolab.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.R;
import com.example.photolab.helpers.Helpers;
import com.example.photolab.ui.listeners.RecyclerViewItemClickListener;
import com.example.photolab.data.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<Photo> mData;
    private LayoutInflater mInflater;
    private RecyclerViewItemClickListener itemClickListener;

    public RecyclerViewAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if(mData != null){
            Photo photo = mData.get(position);
            Picasso.get().load(photo.getPreviewURL()).into(holder.getImageView());
            holder.getLikes().setText(String.valueOf(photo.getLikes()));
            holder.getViews().setText(String.valueOf(photo.getViews()));
            holder.getDownloads().setText(String.valueOf(photo.getDownloads()));
            holder.getDescription().setText(Helpers.capitalize(photo.getTags()));
            if(itemClickListener != null){
                holder.getItem_cardView().setOnClickListener(view -> itemClickListener.onItemClick(view, photo, position));
            }
        }
    }

    @Override
    public int getItemCount() {
        return (mData == null) ? 0 : mData.size();
    }

    public void setmData(List<Photo> data){
        this.mData = data;
        notifyDataSetChanged();
    }

    public List<Photo> getmData() {
        return mData;
    }

    public void setOnItemClickListener(RecyclerViewItemClickListener listener){
        this.itemClickListener = listener;
    }
}
