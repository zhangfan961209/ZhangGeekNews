package com.example.zhangfan.outgeeknews.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;



public abstract class BaseActivity<V extends BaseMvpView,P extends BasePresenter>
        extends AppCompatActivity  implements BaseMvpView{
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if (mPresenter != null){
            mPresenter.bind((V) this);
        }
        initView();
        initListener();
        initData();
    }

    protected abstract P initPresenter();

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView(){

    };

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //切断V层和P层的联系
        mPresenter.onDestory();
        mPresenter = null;
    }
}
