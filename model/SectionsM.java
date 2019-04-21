package com.example.zhangfan.outgeeknews.model;

import com.example.zhangfan.outgeeknews.api.ZhihuService;
import com.example.zhangfan.outgeeknews.base.BaseModel;
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.net.HttpUtils;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SectionsM extends BaseModel{
    public void getData(final ResultCallBack<SectionsBean> callBack){
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sBaseUrl, ZhihuService.class);
        Observable<SectionsBean> sectionsBean = apiserver.getSectionsBean();
        sectionsBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SectionsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SectionsBean sectionsBean) {
                        callBack.onSuccess(sectionsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
