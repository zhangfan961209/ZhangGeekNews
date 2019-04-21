package com.example.zhangfan.outgeeknews.model;

import com.example.zhangfan.outgeeknews.api.ZhihuService;
import com.example.zhangfan.outgeeknews.base.BaseModel;
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.bean.WeChatBean;
import com.example.zhangfan.outgeeknews.net.HttpUtils;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeChatM extends BaseModel{
    public void getData(final ResultCallBack<WeChatBean> callBack){
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sWeChat, ZhihuService.class);
        Observable<WeChatBean> sectionsBean = apiserver.getWeChat();
        sectionsBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        callBack.onSuccess(weChatBean);
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
