package com.example.zhangfan.outgeeknews.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.bean.GlodShowBean;

import java.util.ArrayList;

public class VpGlodAdapter extends FragmentStatePagerAdapter {
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<GlodShowBean> mTitles;
    private ArrayList<String> mNewTitles = new ArrayList<>();

    public VpGlodAdapter(FragmentManager fm,
                         ArrayList<BaseFragment> fragments,
                         ArrayList<GlodShowBean> titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
        for (int i = 0; i < mTitles.size(); i++) {
            GlodShowBean glodShowBean = mTitles.get(i);
            if (glodShowBean.isChecked) {
                mNewTitles.add(glodShowBean.titlee);
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mNewTitles.get(position);
    }
}
