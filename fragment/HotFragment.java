package com.example.zhangfan.outgeeknews.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.adapter.RlvHotAdapter;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.bean.HotBean;
import com.example.zhangfan.outgeeknews.presenter.HotP;
import com.example.zhangfan.outgeeknews.view.HotV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HotFragment extends BaseFragment<HotV, HotP>
        implements HotV {
    @BindView(R.id.recyHot)
    RecyclerView recyHot;
    private ArrayList<HotBean.RecentBean> recentBeans;
    private RlvHotAdapter rlvHotAdapter;

    @Override
    protected HotP initPresenter() {
        return new HotP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void initView() {
        recyHot.setLayoutManager(new LinearLayoutManager(getContext()));
        recentBeans = new ArrayList<>();
        rlvHotAdapter = new RlvHotAdapter(getContext(), recentBeans);
        recyHot.setAdapter(rlvHotAdapter);
    }

    @Override
    public void setData(HotBean bean) {
        List<HotBean.RecentBean> recent = bean.getRecent();
        rlvHotAdapter.setData(recent);
    }


}
