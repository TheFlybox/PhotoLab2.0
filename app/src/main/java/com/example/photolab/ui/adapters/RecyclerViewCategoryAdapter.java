package com.example.photolab.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.R;
import com.example.photolab.ui.listeners.RecyclerViewItemClickListener;
import com.example.photolab.helpers.Helpers;

import java.util.List;

public class RecyclerViewCategoryAdapter extends RecyclerView.Adapter<RecyclerViewCategoryAdapter.RecyclerViewCategoryViewHolder> {
    private List<String> mData;
    private LayoutInflater mInflater;
    private RecyclerViewItemClickListener itemClickListener;

    public RecyclerViewCategoryAdapter(Context context, List<String> data){
        mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public class RecyclerViewCategoryViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public RecyclerViewCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.category_title);
        }
    }

    @NonNull
    @Override
    public RecyclerViewCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_category_item_layout, parent, false);
        return new RecyclerViewCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCategoryViewHolder holder, int position) {
        String row = mData.get(position);
        row = Helpers.capitalize(row);
        holder.textView.setText(row);
        holder.itemView.setOnClickListener(view -> itemClickListener.onItemClick(view, null, position));
    }

    @Override
    public int getItemCount() {
        return (mData==null)?0:mData.size();
    }
    public String getItem(int pos){
        return mData.get(pos);
    }

    public void setOnItemClickListener(RecyclerViewItemClickListener listener){
        itemClickListener = listener;
    }
}
