package com.example.zhangfan.outgeeknews.presenter;


import com.example.zhangfan.outgeeknews.base.BasePresenter;
import com.example.zhangfan.outgeeknews.bean.DailyNewsBean;
import com.example.zhangfan.outgeeknews.model.DailyNewsM;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;
import com.example.zhangfan.outgeeknews.view.DailyNewsV;

public class DailyNewsP extends BasePresenter<DailyNewsV> {

    private DailyNewsM mDailyNewsM;

    @Override
    protected void initModel() {
        mDailyNewsM = new DailyNewsM();
        mModels.add(mDailyNewsM);
    }

    public void getData() {
        mDailyNewsM.getData(new ResultCallBack<DailyNewsBean>() {
            @Override
            public void onSuccess(DailyNewsBean bean) {
                if (bean != null){
                    if (mView != null){
                        mView.setData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
