package com.android.yuanxiong.cpapademo2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.yuanxiong.cpapademo2.R;

/**
 * Created by 李远雄 on 2016/3/21.
 * 图片市场
 */
public class MarketFragment extends BaseFragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_market, container, false);
        }
        return rootView;
    }
}
