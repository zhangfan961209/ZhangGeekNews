package com.example.zhangfan.outgeeknews.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.zhangfan.outgeeknews.fragment.V2exFragment;

import java.util.ArrayList;

public class MyV2exAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public MyV2exAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments) {
        super(supportFragmentManager);
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
}
