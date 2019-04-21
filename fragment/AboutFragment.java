package com.example.zhangfan.outgeeknews.fragment;


import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.presenter.EmptyP;
import com.example.zhangfan.outgeeknews.view.EmptyV;

public class AboutFragment extends BaseFragment<EmptyV,EmptyP>
        implements EmptyV {
    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }
}
