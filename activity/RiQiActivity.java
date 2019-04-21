package com.example.zhangfan.outgeeknews.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.zhangfan.outgeeknews.R;
import com.example.zhangfan.outgeeknews.util.ToastUtil;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RiQiActivity extends AppCompatActivity {
    private MaterialCalendarView mMsv;
    private TextView mTvOk;
    private String mFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ri_qi);
        initView();
    }

    private void initView() {
        mMsv = (MaterialCalendarView) findViewById(R.id.msv);
        mTvOk = (TextView) findViewById(R.id.tv_ok);

        mMsv.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Date dateDate = date.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                mFormat = sdf.format(dateDate);
            }
        });

        mTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(mFormat) > 0) {
                        EventBus.getDefault().post(mFormat);
                        finish();
                    }else{
                        ToastUtil.showShort("年月日不能为空");
                        //finish();
                    }
                } catch (Exception e) {
                    mFormat = "";
                }

            }
        });
    }
}

