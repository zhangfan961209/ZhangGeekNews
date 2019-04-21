package com.example.zhangfan.outgeeknews.api;
import com.example.zhangfan.outgeeknews.bean.DailyNewsBean;
import com.example.zhangfan.outgeeknews.bean.HotBean;
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.bean.WeChatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ZhihuService {
    String sBaseUrl = "https://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<DailyNewsBean> getLastDailyNews();

    @GET("sections")
    Observable<SectionsBean> getSectionsBean();
    @GET("news/hot")
    Observable<HotBean> getHot();
    String sWeChat = "http://api.tianapi.com/wxnew/";
    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WeChatBean> getWeChat();
}
