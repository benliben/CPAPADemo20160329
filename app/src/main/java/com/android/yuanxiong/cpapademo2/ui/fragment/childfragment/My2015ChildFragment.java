package com.android.yuanxiong.cpapademo2.ui.fragment.childfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.yuanxiong.cpapademo2.R;

/**
 * Created by 李远雄 on 2016/3/24.
 */
public class My2015ChildFragment extends Fragment {
    private  View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.widget_fragment_my2016, container, false);
        }
        return rootView;
    }
}
