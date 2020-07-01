package com.example.photolab.ui.fragments;

import android.widget.Toast;

import androidx.viewpager2.widget.ViewPager2;

import com.example.photolab.R;
import com.example.photolab.ui.adapters.ViewPager2Adapter;

import java.util.List;

public class PreviewFragment extends BaseFragment {
    private List<String> data;
    private int selectedPos = -1;

    public PreviewFragment(List<String> data, int pos){
        this.data = data;
        selectedPos = pos;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_preview;
    }

    @Override
    public String getFragmentTitle() {
        return "Preview";
    }

    @Override
    public void setup() {
        ViewPager2 viewPager2 = getView().findViewById(R.id.my_viewpager2);
        ViewPager2Adapter adapter = new ViewPager2Adapter(getContext(), data);
        viewPager2.setAdapter(adapter);
        viewPager2.setCurrentItem(selectedPos);
        Toast.makeText(getContext(), "Swipe LEFT or RIGHT to change Image", Toast.LENGTH_LONG).show();
    }
}
