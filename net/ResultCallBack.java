package com.example.zhangfan.outgeeknews.net;



public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFail(String msg);
}
