package com.example.zhangfan.outgeeknews.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.adapter.MyV2exAdapter;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.bean.V2exBean;
import com.example.zhangfan.outgeeknews.presenter.V2exP;
import com.example.zhangfan.outgeeknews.view.V2exV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class V2exFragment extends BaseFragment<V2exV, V2exP>
        implements V2exV {
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vip)
    ViewPager mVip;
    Unbinder unbinder;
    private String url = "https://www.v2ex.com/";
    private MyV2exAdapter myV2exAdapter;
    private ArrayList<Fragment> fragments;
    private ArrayList<V2exBean> v2exBeans;

    @Override
    protected V2exP initPresenter() {
        return new V2exP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2ex;
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    v2exBeans = new ArrayList<>();
                    Document doc = Jsoup.connect(url).get();
                    Element first = doc.select("div#Tabs").first();
                    Elements select = first.select("a[href]");
                    for (Element element : select) {
                        String href = element.attr("href");
                        String text = element.text();
                        V2exBean v2exBean = new V2exBean(href, text);
                        v2exBeans.add(v2exBean);
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < v2exBeans.size(); i++) {
                                mTab.addTab(mTab.newTab().setText(v2exBeans.get(i).tab));
                                fragments.add(new TabV2exFragment(v2exBeans.get(i).link));
                                myV2exAdapter = new MyV2exAdapter(getChildFragmentManager(), fragments);
                                mVip.setAdapter(myV2exAdapter);

                                mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                                    @Override
                                    public void onTabSelected(TabLayout.Tab tab) {
                                        mVip.setCurrentItem(tab.getPosition());
                                    }
                                    @Override
                                    public void onTabUnselected(TabLayout.Tab tab) {
                                    }
                                    @Override
                                    public void onTabReselected(TabLayout.Tab tab) {
                                    }
                                });
                                mVip.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
                            }
                        }
                    });
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }).start();

    }
}
