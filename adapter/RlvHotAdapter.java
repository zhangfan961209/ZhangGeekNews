package com.example.zhangfan.outgeeknews.adapter;

import android.content.Context;
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
import com.example.zhangfan.outgeeknews.bean.HotBean;
import com.example.zhangfan.outgeeknews.bean.SectionsBean;
import com.example.zhangfan.outgeeknews.fragment.HotFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvHotAdapter extends RecyclerView.Adapter<RlvHotAdapter.ViewHolder> {


    private Context activity;
    private ArrayList<HotBean.RecentBean> recentBeans;
    private HotBean data;

    public RlvHotAdapter(Context activity, ArrayList<HotBean.RecentBean> recentBeans) {
        this.activity = activity;
        this.recentBeans = recentBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_timehot, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HotBean.RecentBean recentBean = recentBeans.get(position);
        Glide.with(activity).load(recentBean.getThumbnail()).into(holder.zhihuImg);
        holder.tvTimel.setText(recentBean.getTitle());

    }

    @Override
    public int getItemCount() {
        return recentBeans.size();
    }

    public void setData(HotBean data) {
        this.data = data;

    }

    public void setData(List<HotBean.RecentBean> recent) {
        recentBeans.clear();
        if (recent != null && recent.size() > 0) {
            recentBeans.addAll(recent);
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.zhihu_img)
        ImageView zhihuImg;
        @BindView(R.id.tv_timel)
        TextView tvTimel;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
