package com.example.footballproject;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFregmentTitleList = new ArrayList<>();
    int id;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment,String title,int matchId){
        mFragmentList.add(fragment);
        mFregmentTitleList.add(title);
        id=matchId;
    }
    public CharSequence getPageTitle(int position){
        return mFregmentTitleList.get(position);
    }

    public int getId() {
        return id;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
