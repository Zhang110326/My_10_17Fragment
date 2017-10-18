package com.example.administrator.my_10_17fragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.my_10_17fragment.R;
import com.example.administrator.my_10_17fragment.adapter.FragmentAdapter;
import com.example.administrator.my_10_17fragment.fragment_1.Fragment_one;
import com.example.administrator.my_10_17fragment.fragment_1.Fragment_si;
import com.example.administrator.my_10_17fragment.fragment_1.Fragment_thress;
import com.example.administrator.my_10_17fragment.fragment_1.Fragment_two;
import com.example.administrator.my_10_17fragment.fragment_1.Fragment_wu;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/17.
 */

public class Fragment_zhu extends Fragment {
    private ArrayList<String> arrayList;
    private ArrayList<Fragment> fragments;
    private TabLayout tabOne;
    private ViewPager vpPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhu_layout, container,false);
        initView(view);
        initData();
        initadapter();
        return view;

    }

    private void initData() {
        arrayList = new ArrayList<>();
        fragments = new ArrayList<>();
        arrayList.add("首页");
        arrayList.add("视频");
        arrayList.add("直播");
        arrayList.add("段子");
        arrayList.add("游戏");
        fragments.add(new Fragment_one());
        fragments.add(new Fragment_two());
        fragments.add(new Fragment_thress());
        fragments.add(new Fragment_si());
        fragments.add(new Fragment_wu());
    }


    private void initView(View view) {

        tabOne = view.findViewById(R.id.tab_one);
        vpPager = view.findViewById(R.id.vp_pager);
    }

    private void initadapter() {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(),arrayList,fragments);
        vpPager.setAdapter(fragmentAdapter);
        tabOne.setupWithViewPager(vpPager);


    }

}
