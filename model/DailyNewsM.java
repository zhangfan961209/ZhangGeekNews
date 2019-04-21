package com.example.zhangfan.outgeeknews.model;


import com.example.zhangfan.outgeeknews.base.BaseModel;
import com.example.zhangfan.outgeeknews.bean.DailyNewsBean;
import com.example.zhangfan.outgeeknews.net.BaseObserver;
import com.example.zhangfan.outgeeknews.net.HttpUtils;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;
import com.example.zhangfan.outgeeknews.net.RxUtils;
import com.example.zhangfan.outgeeknews.api.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class DailyNewsM extends BaseModel {
    public void getData(final ResultCallBack<DailyNewsBean> callBack) {
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sBaseUrl, ZhihuService.class);
        Observable<DailyNewsBean> lastDailyNews = apiserver.getLastDailyNews();
        lastDailyNews.compose(RxUtils.<DailyNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        callBack.onSuccess(dailyNewsBean);
                    }
                });
    }
}
