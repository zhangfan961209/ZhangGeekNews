package com.example.zhangfan.outgeeknews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.activity.RiQiActivity;
import com.example.zhangfan.outgeeknews.adapter.RlvDailyNewsAdapter;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.bean.DailyNewsBean;
import com.example.zhangfan.outgeeknews.presenter.DailyNewsP;
import com.example.zhangfan.outgeeknews.view.DailyNewsV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DailyNewsFragment extends BaseFragment<DailyNewsV, DailyNewsP>
        implements DailyNewsV {
    private static final String TAG = "DailyNewsFragment";
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;
    private RlvDailyNewsAdapter mAdapter;

    @Override
    protected DailyNewsP initPresenter() {
        return new DailyNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_news;
    }

    @Override
    protected void initView() {
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<DailyNewsBean.StoriesBean> newsList = new ArrayList<>();
        ArrayList<DailyNewsBean.TopStoriesBean> banners = new ArrayList<>();
        mAdapter = new RlvDailyNewsAdapter(getContext(),
                newsList, banners);
        mRlv.setAdapter(mAdapter);

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }

    @Override
    public void setData(DailyNewsBean bean) {
        mAdapter.setData(bean);
    }

    @OnClick(R.id.floatingActionButton)
    public void onViewClicked() {
        Intent intent=new Intent(getActivity(),RiQiActivity.class);
       startActivity(intent);
    }
}
