package com.example.zhangfan.outgeeknews.fragment;

import android.os.Bundle;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.base.Constants;
import com.example.zhangfan.outgeeknews.presenter.GoldDetailP;
import com.example.zhangfan.outgeeknews.view.GlodDetailV;


public class GlodDetailFragment extends BaseFragment<GlodDetailV,GoldDetailP> implements GlodDetailV {

    public GlodDetailFragment() {
        // Required empty public constructor
    }

    @Override
    protected GoldDetailP initPresenter() {
        return new GoldDetailP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_glod_detail;
    }
    public static GlodDetailFragment newInstance(String text){
        GlodDetailFragment fragment = new GlodDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA,text);
        fragment.setArguments(bundle);
        return fragment;
    }
}
