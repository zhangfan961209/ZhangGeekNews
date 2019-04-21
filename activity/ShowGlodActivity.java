package com.example.zhangfan.outgeeknews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.adapter.ShowGoldAdapter;
import com.example.zhangfan.outgeeknews.base.BaseActivity;
import com.example.zhangfan.outgeeknews.base.Constants;
import com.example.zhangfan.outgeeknews.bean.GlodShowBean;
import com.example.zhangfan.outgeeknews.presenter.ShowGlodP;
import com.example.zhangfan.outgeeknews.view.ShowGlodV;
import com.example.zhangfan.outgeeknews.widget.SimpleCallBack;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowGlodActivity extends BaseActivity<ShowGlodV, ShowGlodP> implements ShowGlodV {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ArrayList<GlodShowBean> mList;

    @Override
    protected ShowGlodP initPresenter() {
        return new ShowGlodP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_glod;
    }
    @Override
    protected void initView() {
        mList = (ArrayList<GlodShowBean>) getIntent().getSerializableExtra(Constants.DATA);

        mToolBar.setTitle(R.string.special_show);
        mToolBar.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(mToolBar);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAct();
            }
        });

        mRlv.setLayoutManager(new LinearLayoutManager(this));
        ShowGoldAdapter adapter = new ShowGoldAdapter(mList);
        mRlv.setAdapter(adapter);
        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        SimpleCallBack simpleCallBack = new SimpleCallBack(adapter);
        simpleCallBack.setSwipeEnable(true);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallBack);
        itemTouchHelper.attachToRecyclerView(mRlv);

    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA, mList);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAct();
    }
}
