package com.example.zhangfan.outgeeknews.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.adapter.VpZhihuAdapter;
import com.example.zhangfan.outgeeknews.base.BaseFragment;
import com.example.zhangfan.outgeeknews.presenter.ZhihuDailyNewsP;
import com.example.zhangfan.outgeeknews.view.ZhihuDailyNewsV;

import java.util.ArrayList;

import butterknife.BindView;



public class ZhihuDailyNewsFragment extends BaseFragment<ZhihuDailyNewsV, ZhihuDailyNewsP>
        implements ZhihuDailyNewsV {
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.vp)
    ViewPager mVp;
    private ArrayList<Integer> mTitles;
    private ArrayList<BaseFragment> mFragments;

    @Override
    protected ZhihuDailyNewsP initPresenter() {
        return new ZhihuDailyNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_daily_news;
    }

    @Override
    protected void initView() {
        initTitles();
        initFragments();

        VpZhihuAdapter adapter = new VpZhihuAdapter(getContext(),
                getChildFragmentManager(), mFragments, mTitles);
        mVp.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mVp);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new DailyNewsFragment());
        mFragments.add(new SectionsFragment());
        mFragments.add(new HotFragment());
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(R.string.dailyNews);
        mTitles.add(R.string.sections);
        mTitles.add(R.string.hot);
    }
}
