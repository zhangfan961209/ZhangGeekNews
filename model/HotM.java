package com.example.zhangfan.outgeeknews.model;

import com.example.zhangfan.outgeeknews.api.ZhihuService;
import com.example.zhangfan.outgeeknews.base.BaseModel;
import com.example.zhangfan.outgeeknews.bean.HotBean;
import com.example.zhangfan.outgeeknews.net.HttpUtils;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;
import com.example.zhangfan.outgeeknews.util.ToastUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HotM extends BaseModel{
    public void getData(final ResultCallBack<HotBean> callBack){
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sBaseUrl, ZhihuService.class);
        Observable<HotBean> hot = apiserver.getHot();
        hot.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callBack.onSuccess(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtil.showShort("错误数据");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
