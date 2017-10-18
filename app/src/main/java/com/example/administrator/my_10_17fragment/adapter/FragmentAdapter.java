package com.example.administrator.my_10_17fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/17.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<String> arrayList;
    private ArrayList<Fragment> fragments;

    public FragmentAdapter(FragmentManager fm, ArrayList<String> arrayList, ArrayList<Fragment> fragments) {
        super(fm);
        this.arrayList = arrayList;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  arrayList.get(position);
    }
}