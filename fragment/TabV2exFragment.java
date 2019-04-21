package com.example.zhangfan.outgeeknews.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.adapter.MyV2exFragmentAdapter;
import com.example.zhangfan.outgeeknews.bean.V2exFragmentBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class TabV2exFragment extends Fragment {


    private String link;
    @BindView(R.id.v2ex_recy)
    RecyclerView mV2exRecy;
    private String url = "https://www.v2ex.com/";
    private ArrayList v2exFragmentBeans;
    private String text;
    private String href;
    private MyV2exFragmentAdapter myV2exFragmentAdapter;
    private String topicText;

    @SuppressLint("ValidFragment")
    public TabV2exFragment(String link) {
        // Required empty public constructor
        this.link = link;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_v2ex, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
       new Thread(new Runnable() {
           @Override
           public void run() {

               try {
                   v2exFragmentBeans = new ArrayList<>();
                   Document document = Jsoup.connect(url).get();
                   Elements select = document.select("div.cell.item");
                   for (Element element : select) {
                       Element img = element.select("table tbody tr td > a >img.avatar").first();
                       String src = img.attr("src");
                       Elements pinglun = element.select("table tbody tr td >a.count_livid");
                       if (pinglun != null) {
                           text = pinglun.text();
                           href = pinglun.attr("href");
                       }
                       Elements title = element.select("table tbody tr td span.item_title > a");
                       String titleText = title.text();
                       Elements topic = element.select("table tbody tr td span.topic_info");
                       link = topic.text();
                       V2exFragmentBean v2exFragmentBean = new V2exFragmentBean(src, text, href, titleText, link);
                       v2exFragmentBeans.add(v2exFragmentBean);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mV2exRecy.setLayoutManager(new LinearLayoutManager(getContext()));
                                myV2exFragmentAdapter = new MyV2exFragmentAdapter(getActivity(), v2exFragmentBeans);
                                mV2exRecy.setAdapter(myV2exFragmentAdapter);
                            }
                        });
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }


}
