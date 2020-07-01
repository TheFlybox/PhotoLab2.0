package com.example.photolab.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photolab.helpers.Helpers;

public abstract class BaseFragment extends Fragment {
    private View view;

    @Override
    public void onResume() {
        super.onResume();
        changeTitle();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        setup();
        return view;
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    public AppCompatActivity getCompatActivity(){
        return (AppCompatActivity)getActivity();
    }
    private void changeTitle(){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(Helpers.capitalize(getFragmentTitle()));
    }

    public abstract int getLayout();
    public abstract String getFragmentTitle();
    public abstract void setup();
    public RecyclerView getRecyclerView(){ return null; }
}
