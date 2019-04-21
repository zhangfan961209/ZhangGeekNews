package com.example.zhangfan.outgeeknews.presenter;


import com.example.zhangfan.outgeeknews.base.BasePresenter;
import com.example.zhangfan.outgeeknews.bean.WeChatBean;
import com.example.zhangfan.outgeeknews.model.WeChatM;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;
import com.example.zhangfan.outgeeknews.view.WeChatV;

public class WeChatP extends BasePresenter<WeChatV> {

    private WeChatM mWeChatM;

    @Override
    protected void initModel() {
        mWeChatM = new WeChatM();
        mModels.add(mWeChatM);
    }
    public void getData(){
        mWeChatM.getData(new ResultCallBack<WeChatBean>() {
            @Override
            public void onSuccess(WeChatBean bean) {
                if (mView != null) {
                    mView.setData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
