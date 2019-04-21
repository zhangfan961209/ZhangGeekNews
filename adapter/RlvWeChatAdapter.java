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
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.bean.WeChatBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvWeChatAdapter extends RecyclerView.Adapter<RlvWeChatAdapter.ViewHolder> {

    private FragmentActivity activity;
    private ArrayList<WeChatBean.NewslistBean> dataBeans;
    private WeChatBean data;

    public RlvWeChatAdapter(FragmentActivity activity, ArrayList<WeChatBean.NewslistBean> dataBeans) {
        this.activity = activity;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.wechat, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeChatBean.NewslistBean dataBean = dataBeans.get(position);
        Glide.with(activity).load(dataBean.getPicUrl()).into(holder.sectionsImg);
        holder.sectionsContent.setText(dataBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public void setData(WeChatBean data) {
        dataBeans.clear();
        if (data != null && data.getNewslist().size() > 0) {
            dataBeans.addAll(data.getNewslist());
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sections_img)
        ImageView sectionsImg;
        @BindView(R.id.sections_content)
        TextView sectionsContent;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
