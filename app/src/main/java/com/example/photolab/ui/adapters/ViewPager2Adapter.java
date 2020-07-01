package com.example.photolab.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2AdapterViewHolder> {

    private List<String> data;
    private LayoutInflater inflater;

    public ViewPager2Adapter(Context context, List<String> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewPager2AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewpager2_item_layout, parent, false);
        return new ViewPager2AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPager2AdapterViewHolder holder, int position) {
        if(data != null){
            Picasso.get().load(data.get(position)).into(holder.getImageView());
        }
    }

    @Override
    public int getItemCount() {
        return (data == null) ? 0 : data.size();
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
