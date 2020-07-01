package com.example.photolab.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;

import com.example.photolab.R;
import com.example.photolab.helpers.Helpers;
import com.example.photolab.ui.fragments.BaseFragment;
import com.example.photolab.ui.fragments.CategoryFragment;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        Toolbar toolbar = findViewById(R.id.entry_toolbar);
        setSupportActionBar(toolbar);

        loadFragment(new CategoryFragment(), this);
    }

    public static void loadFragment(BaseFragment fragment, AppCompatActivity activity){
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.addToBackStack("xd");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) { super.onBackPressed(); }
        else { getSupportFragmentManager().popBackStack(); }
    }
}