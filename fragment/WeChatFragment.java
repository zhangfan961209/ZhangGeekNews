package com.example.zhangfan.outgeeknews.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.adapter.RlvWeChatAdapter;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.bean.WeChatBean;
import com.example.zhangfan.outgeeknews.presenter.WeChatP;
import com.example.zhangfan.outgeeknews.view.WeChatV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class WeChatFragment extends BaseFragment<WeChatV, WeChatP>
        implements WeChatV {
    @BindView(R.id.wechat_recy)
    RecyclerView wechatRecy;
    Unbinder unbinder;
    private ArrayList<WeChatBean.NewslistBean> newslistBeans;
    private RlvWeChatAdapter rlvWeChatAdapter;

    @Override
    protected WeChatP initPresenter() {
        return new WeChatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initView() {
        wechatRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        newslistBeans = new ArrayList<>();
        rlvWeChatAdapter = new RlvWeChatAdapter(getActivity(), newslistBeans);
        wechatRecy.setAdapter(rlvWeChatAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setData(WeChatBean bean) {
        rlvWeChatAdapter.setData(bean);
    }
}
