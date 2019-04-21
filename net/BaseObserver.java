package com.example.zhangfan.outgeeknews.net;

import android.util.Log;


import com.example.zhangfan.outgeeknews.util.ToastUtil;

import io.reactivex.Observer;




public abstract class BaseObserver<T> implements Observer<T> {
    private final String TAG = getClass().getName();

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: "+e.toString());
        ToastUtil.showShort("数据加载失败");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }
}
