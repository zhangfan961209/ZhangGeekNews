package com.example.zhangfan.outgeeknews.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.bean.V2exFragmentBean;

import java.util.ArrayList;

public class MyV2exFragmentAdapter extends RecyclerView.Adapter<MyV2exFragmentAdapter.ViewHolder>{

    private FragmentActivity activity;
    private ArrayList<V2exFragmentBean> v2exFragmentBeans;

    public MyV2exFragmentAdapter(FragmentActivity activity, ArrayList<V2exFragmentBean> v2exFragmentBeans) {

        this.activity = activity;
        this.v2exFragmentBeans = v2exFragmentBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.v2ex_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        V2exFragmentBean v2exFragmentBean = v2exFragmentBeans.get(position);
        String url = "https://"+v2exFragmentBean.src;
        Glide.with(activity).load(url).into(holder.img);
        holder.text_context.setText(v2exFragmentBean.titleText);
        holder.text_name.setText(v2exFragmentBean.href);
        holder.text_pic.setText(v2exFragmentBean.topictext);
        holder.text_pinglun.setText(v2exFragmentBean.text);
    }

    @Override
    public int getItemCount() {
        return v2exFragmentBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_pinglun;
        TextView text_pic;
        TextView text_context;
        TextView text_name;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            text_pinglun = itemView.findViewById(R.id.text_pinglun);
            text_pic = itemView.findViewById(R.id.text_pic);
            text_context = itemView.findViewById(R.id.text_context);
            text_name = itemView.findViewById(R.id.text_name);
            img = itemView.findViewById(R.id.img);
        }
    }
}
