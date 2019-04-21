package com.example.zhangfan.outgeeknews.fragment;


import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.presenter.GankP;
import com.example.zhangfan.outgeeknews.view.GankV;

public class GankFragment extends BaseFragment<GankV,GankP>
        implements GankV {
    @Override
    protected GankP initPresenter() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }
}
