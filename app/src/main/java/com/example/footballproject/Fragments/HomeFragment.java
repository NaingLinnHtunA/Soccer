package com.example.footballproject.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.footballproject.R;
import com.example.footballproject.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {
    TabAdapter tabAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    View rootView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.content_home,container,false);

        tabLayout = rootView.findViewById(R.id.tabLayout);
        viewPager = rootView.findViewById(R.id.viewPager);

        tabAdapter = new TabAdapter(getFragmentManager());
        tabAdapter.addFragment(new YesterdayFragment(),"Yesterday",0);
        tabAdapter.addFragment(new TodayFragment(),"Today",0);
        tabAdapter.addFragment(new TomorrowFragment(),"Tomorrow",0);

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getSelectedTabPosition();

        return rootView;
    }
}
