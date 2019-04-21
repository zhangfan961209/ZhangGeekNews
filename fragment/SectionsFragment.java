package com.example.zhangfan.outgeeknews.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.adapter.RlvSectionsAdapter;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.presenter.EmptyP;
import com.example.zhangfan.outgeeknews.presenter.SectionsP;
import com.example.zhangfan.outgeeknews.view.EmptyV;
import com.example.zhangfan.outgeeknews.view.SectionsV;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SectionsFragment extends BaseFragment<SectionsV, SectionsP>
        implements SectionsV {
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.smfl)
    SmartRefreshLayout smfl;

    private ArrayList<SectionsBean.DataBean> dataBeans;
    private RlvSectionsAdapter rlvSectionsAdapter;

    @Override
    protected SectionsP initPresenter() {
        return new SectionsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sections;
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new GridLayoutManager(getContext(), 2));
        dataBeans = new ArrayList<>();
        rlvSectionsAdapter = new RlvSectionsAdapter(getActivity(), dataBeans);
        recy.setAdapter(rlvSectionsAdapter);
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
    public void setData(SectionsBean bean) {
        rlvSectionsAdapter.setData(bean);

    }
}
