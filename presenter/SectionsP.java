package com.example.zhangfan.outgeeknews.presenter;

import com.example.zhangfan.outgeeknews.base.BasePresenter;
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.model.EmptyM;
import com.example.zhangfan.outgeeknews.model.SectionsM;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;
import com.example.zhangfan.outgeeknews.view.EmptyV;
import com.example.zhangfan.outgeeknews.view.SectionsV;

public class SectionsP extends BasePresenter<SectionsV> {
    private SectionsM mSectionsM;
    @Override
    protected void initModel() {
        mSectionsM = new SectionsM();
        mModels.add(mSectionsM);
    }

    public void getData() {
        mSectionsM.getData(new ResultCallBack<SectionsBean>() {
            @Override
            public void onSuccess(SectionsBean bean) {
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
