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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvSectionsAdapter extends RecyclerView.Adapter<RlvSectionsAdapter.ViewHolder> {

    private FragmentActivity activity;
    private ArrayList<SectionsBean.DataBean> dataBeans;
    private SectionsBean data;

    public RlvSectionsAdapter(FragmentActivity activity, ArrayList<SectionsBean.DataBean> dataBeans) {
        this.activity = activity;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.sections, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SectionsBean.DataBean dataBean = dataBeans.get(position);
        Glide.with(activity).load(dataBean.getThumbnail()).into(holder.sectionsImg);
        holder.sectionsContent.setText(dataBean.getDescription());
        holder.sectionsName.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public void setData(SectionsBean data) {
        this.data = data;
        dataBeans.clear();
        if (data.getData() != null && data.getData().size() > 0) {
            dataBeans.addAll(data.getData());
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sections_img)
        ImageView sectionsImg;
        @BindView(R.id.sections_content)
        TextView sectionsContent;
        @BindView(R.id.sections_name)
        TextView sectionsName;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
