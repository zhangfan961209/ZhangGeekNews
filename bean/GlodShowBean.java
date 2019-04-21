package com.example.zhangfan.outgeeknews.bean;

import java.io.Serializable;

public class GlodShowBean implements Serializable{
    public String titlee;
    public boolean isChecked;

    public GlodShowBean(String title, boolean isChecked) {
        this.titlee = title;
        this.isChecked = isChecked;
    }
}
