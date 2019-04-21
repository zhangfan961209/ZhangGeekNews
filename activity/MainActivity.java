package com.example.zhangfan.outgeeknews.activity;



import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.base.BaseActivity;
import com.example.zhangfan.outgeeknews.fragment.AboutFragment;
import com.example.zhangfan.outgeeknews.fragment.CollectFragment;
import com.example.zhangfan.outgeeknews.fragment.GankFragment;
import com.example.zhangfan.outgeeknews.fragment.GoldFragment;
import com.example.zhangfan.outgeeknews.fragment.SettingFragment;
import com.example.zhangfan.outgeeknews.fragment.V2exFragment;
import com.example.zhangfan.outgeeknews.fragment.WeChatFragment;
import com.example.zhangfan.outgeeknews.fragment.ZhihuDailyNewsFragment;
import com.example.zhangfan.outgeeknews.presenter.MainP;
import com.example.zhangfan.outgeeknews.view.MainView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import io.reactivex.annotations.NonNull;

public class MainActivity extends BaseActivity<MainView, MainP> implements MainView {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.nv)
    NavigationView mNv;
    @BindView(R.id.dl)
    DrawerLayout mDl;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Integer> mTitles;
    private FragmentManager mManager;
    private final int TYPE_ZHIHU = 0;
    private final int TYPE_WECHAT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_V2EX = 4;
    private final int TYPE_COLLECT = 5;
    private final int TYPE_SETTINGS = 6;
    private final int TYPE_ABOUT = 7;
    private int mLastFragmentPosition;
    private MenuItem mSearchItem;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mManager = getSupportFragmentManager();
        mToolBar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToolBar, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDl.addDrawerListener(toggle);
        toggle.syncState();

        initFragments();
        initTitles();
        addZhihuDailyNewsFragment();
        //本地搜索
        //mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
    }

    private void addZhihuDailyNewsFragment() {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.fragment_container,mFragments.get(0));
        transaction.commit();

        mToolBar.setTitle(mTitles.get(0));
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(R.id.zhihu);
        mTitles.add(R.id.wechat);
        mTitles.add(R.id.gank);
        mTitles.add(R.id.gold);
        mTitles.add(R.id.v2ex);
        mTitles.add(R.id.collect);
        mTitles.add(R.id.settings);
        mTitles.add(R.id.about);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new ZhihuDailyNewsFragment());
        mFragments.add(new WeChatFragment());
        mFragments.add(new GankFragment());
        mFragments.add(new GoldFragment());
        mFragments.add(new V2exFragment());
        mFragments.add(new CollectFragment());
        mFragments.add(new SettingFragment());
        mFragments.add(new AboutFragment());
    }

    @Override
    protected void initListener() {
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId != R.id.info_title && itemId != R.id.option_title){
                    item.setChecked(true);
                    switch (itemId) {
                        case R.id.zhihu:
                            switchFragment(TYPE_ZHIHU);
                            break;
                        case R.id.wechat:
                            switchFragment(TYPE_WECHAT);
                            break;
                        case R.id.gank:
                            switchFragment(TYPE_GANK);
                            break;
                        case R.id.gold:
                            switchFragment(TYPE_GOLD);
                            break;
                        case R.id.v2ex:
                            switchFragment(TYPE_V2EX);
                            break;
                        case R.id.collect:
                            switchFragment(TYPE_COLLECT);
                            break;
                        case R.id.settings:
                            switchFragment(TYPE_SETTINGS);
                            break;
                        case R.id.about:
                            switchFragment(TYPE_ABOUT);
                            break;
                    }
                    mDl.closeDrawer(Gravity.LEFT);
                }else {
                    item.setChecked(false);
                }
                return false;
            }
        });
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //按下搜索或者提交的时候回调,
                //ToastUtil.showShort("提交的内容:"+query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //搜索框内容发生改变的回调,
                //ToastUtil.showShort(newText);
                return false;
            }
        });
        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //搜索框展示
                //ToastUtil.showShort("展示");
            }

            @Override
            public void onSearchViewClosed() {
                //搜索框隐藏
                //ToastUtil.showShort("关闭");
            }
        });
    }

    private void switchFragment(int type) {
        //显示一个fragmnet,隐藏一个Fragment
        //显示
        Fragment fragment = mFragments.get(type);
        //需要隐藏
        Fragment hideFragment = mFragments.get(mLastFragmentPosition);
        FragmentTransaction transaction = mManager.beginTransaction();
        if (!fragment.isAdded()){
            transaction.add(R.id.fragment_container,fragment);
        }

        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();

        mLastFragmentPosition = type;
        //显示或者隐藏搜索框
        if (type == TYPE_WECHAT || type == TYPE_GANK){
            mSearchItem.setVisible(true);
        }else {
            mSearchItem.setVisible(false);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        mSearchItem = menu.findItem(R.id.action_search);
        //隐藏搜索框
        mSearchItem.setVisible(false);
        mSearchView.setMenuItem(mSearchItem);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
