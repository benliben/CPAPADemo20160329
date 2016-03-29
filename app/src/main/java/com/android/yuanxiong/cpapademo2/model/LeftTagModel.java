package com.android.yuanxiong.cpapademo2.model;

import android.support.v4.app.Fragment;

/**
 * Created by 李远雄 on 2016/3/18.
 */
public class LeftTagModel {
    int img_press;
    int img_noremal;
    String name;
    Fragment fragment;

    public int getImg_press() {
        return img_press;
    }

    public void setImg_press(int img_press) {
        this.img_press = img_press;
    }

    public int getImg_noremal() {
        return img_noremal;
    }

    public void setImg_noremal(int img_noremal) {
        this.img_noremal = img_noremal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
