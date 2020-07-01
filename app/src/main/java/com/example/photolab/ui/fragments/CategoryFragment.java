package com.example.photolab.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.R;
import com.example.photolab.helpers.Helpers;
import com.example.photolab.ui.EntryActivity;
import com.example.photolab.ui.adapters.RecyclerViewCategoryAdapter;

import java.util.Arrays;

public class CategoryFragment extends BaseFragment {
    private RecyclerView recyclerView;
    @Override
    public int getLayout() {
        return R.layout.activity_category;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public String getFragmentTitle() {
        return "Categories";
    }

    @Override
    public void setup(){
        RecyclerViewCategoryAdapter adapter = new RecyclerViewCategoryAdapter(getContext(), Arrays.asList(Helpers.API_CATEGORIES));
        adapter.setOnItemClickListener((element, photo, position) -> {
            EntryActivity.loadFragment(new ImageFragment(adapter.getItem(position)), getCompatActivity());
        });

        recyclerView = getView().findViewById(R.id.category_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
