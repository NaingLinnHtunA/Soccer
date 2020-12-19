package com.example.footballproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.footballproject.TabAdapter;
import com.example.footballproject.R;
import com.google.android.material.tabs.TabLayout;

public class PremierLeagueFragment extends Fragment {
    TabLayout tabLayout;
    TabAdapter tabAdapter;
    ViewPager viewPager;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.league_views,container,false);

        tabLayout = rootView.findViewById(R.id.tabLayout);
        viewPager = rootView.findViewById(R.id.viewPager);

        tabAdapter = new TabAdapter(getFragmentManager());

        tabAdapter.addFragment(new TableFragment(),"Table",0);
        tabAdapter.addFragment(new MatchFragment(),"Matches",0);


        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getSelectedTabPosition();


        return rootView;
    }
}
