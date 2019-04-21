package com.example.zhangfan.outgeeknews.model;


import com.example.zhangfan.outgeeknews.base.BaseModel;
import com.example.zhangfan.outgeeknews.bean.LoginBean;
import com.example.zhangfan.outgeeknews.net.ApiService;
import com.example.zhangfan.outgeeknews.net.BaseObserver;
import com.example.zhangfan.outgeeknews.net.HttpUtils;
import com.example.zhangfan.outgeeknews.net.ResultCallBack;
import com.example.zhangfan.outgeeknews.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;




public class LoginM extends BaseModel {
    private static final String TAG = "LoginM";

    public void login(String name, String psd, final ResultCallBack callBack) {
/*        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.sBaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Observable<LoginBean> login = apiService.login(name, psd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //切断观察者和被观察者的连接,找到合适的时机,界面退出的时候
                        //
                        //d.dispose();
                        Log.d(TAG, "onSubscribe: ");
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        Observable<LoginBean> login1 = apiserver.login(name, psd);
        login1.compose(RxUtils.<LoginBean>rxObserableSchedulerHelper())//切换线程
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        callBack.onSuccess(bean);
                    }
                });
    }


}
