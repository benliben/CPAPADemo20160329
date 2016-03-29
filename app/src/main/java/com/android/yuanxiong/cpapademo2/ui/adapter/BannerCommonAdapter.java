package com.android.yuanxiong.cpapademo2.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 李远雄 on 2016/3/24.
 */
public class BannerCommonAdapter extends PagerAdapter {

    private Context mContext;
    private List<ImageView> mImageViews ;

    public BannerCommonAdapter(Context mContext, List<ImageView> mImageViews) {
        this.mContext = mContext;
        this.mImageViews = mImageViews;
    }


    /*计数*/
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition=position%mImageViews.size();
        View view = mImageViews.get(newPosition);
        if (view.getParent() != null) {
            container.removeView(view);
        }
        container.addView(view);
        return view;
    }
}
