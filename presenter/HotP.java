package com.example.zhangfan.outgeeknews.presenter;

import com.example.zhangfan.outgeeknews.base.BasePresenter;
import com.example.zhangfan.outgeeknews.bean.HotBean;
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.model.HotM;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;
import com.example.zhangfan.outgeeknews.util.ToastUtil;
import com.example.zhangfan.outgeeknews.view.HotV;

public class HotP extends BasePresenter<HotV> {
    private HotM mHotM;
    @Override
    protected void initModel() {
        mHotM = new HotM();
       mModels.add(mHotM);
    }
    public void getData() {
        mHotM.getData(new ResultCallBack<HotBean>() {
            @Override
            public void onSuccess(HotBean bean) {
                if (mView != null) {
                    mView.setData(bean);
                }
            }

            @Override
            public void onFail(String msg) {
                ToastUtil.showShort("数据加载失败");
            }
        });
    }


}
