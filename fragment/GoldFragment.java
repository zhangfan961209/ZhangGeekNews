package com.example.zhangfan.outgeeknews.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.activity.ShowGlodActivity;
import com.example.zhangfan.outgeeknews.adapter.VpGlodAdapter;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.base.Constants;
import com.example.zhangfan.outgeeknews.bean.GlodShowBean;
import com.example.zhangfan.outgeeknews.presenter.GoldP;
import com.example.zhangfan.outgeeknews.view.GankV;
import com.example.zhangfan.outgeeknews.view.GoldV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class GoldFragment extends BaseFragment<GoldV, GoldP>
        implements GoldV {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.vip)
    ViewPager vip;
    private ArrayList<GlodShowBean> glodShowBeans;
    private ArrayList<BaseFragment> mFragments;

    @Override
    protected GoldP initPresenter() {
        return new GoldP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }
    @Override
    protected void initView() {
        initTitle();
        setFragments();
    }

    private void setFragments() {
        initFragments();
        VpGlodAdapter adapter = new VpGlodAdapter(getChildFragmentManager(),
                mFragments, glodShowBeans);
        vip.setAdapter(adapter);
        tab.setupWithViewPager(vip);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < glodShowBeans.size(); i++) {
            GlodShowBean bean = glodShowBeans.get(i);
            if (bean.isChecked){
                mFragments.add(GlodDetailFragment.newInstance(bean.titlee));
            }
        }
    }

    private void initTitle() {
        glodShowBeans = new ArrayList<>();
        glodShowBeans.add(new GlodShowBean("Android",true));
        glodShowBeans.add(new GlodShowBean("工具资源",true));
        glodShowBeans.add(new GlodShowBean("设计",true));
        glodShowBeans.add(new GlodShowBean("产品",true));
        glodShowBeans.add(new GlodShowBean("阅读",true));
        glodShowBeans.add(new GlodShowBean("前端",true));
        glodShowBeans.add(new GlodShowBean("后端",true));
        glodShowBeans.add(new GlodShowBean("iOS",true));
    }

    @OnClick({R.id.iv})
    public void click(View v){
        switch (v.getId()) {
            case R.id.iv:
                go2ShowActivity();
                break;
        }
    }

    private void go2ShowActivity() {
        Intent intent = new Intent(getContext(), ShowGlodActivity.class);
        intent.putExtra(Constants.DATA,glodShowBeans);
//        startActivityForResult();
        //getActivity().startActivityForResult(intent,200);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null){
            if (requestCode == 100 && resultCode == Activity.RESULT_OK){
                glodShowBeans = (ArrayList<GlodShowBean>) data.getSerializableExtra(Constants.DATA);
                //刷新界面
                setFragments();
            }
        }
    }

}
