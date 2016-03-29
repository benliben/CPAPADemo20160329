package com.android.yuanxiong.cpapademo2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.ui.fragment.childfragment.HistoryFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.childfragment.My2015ChildFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.childfragment.UpLoadFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.childfragment.ZGFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 李远雄 on 2016/3/21.
 * 我的2016
 */
public class My2016Fragment extends BaseFragment {

    @Bind(R.id.my2015RadioGroup)
    RadioGroup m2015RadioGroup;
    private View rootView;
    private List<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_my2016, container, false);
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        initFragment();
        switchFragment(fragments.get(0));
        m2015RadioGroup.setOnCheckedChangeListener(mChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int position = 0;
            switch (checkedId) {
                case R.id.rad_1:
                    position = 0;
                    break;
                case R.id.rad_2:
                    position = 1;
                    break;
                case R.id.rad_3:
                    position = 2;
                    break;
                case R.id.rad_4:
                    position = 3;
                    break;
            }
            switchFragment(fragments.get(position));
        }
    };

    private void switchFragment(Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.my2015Content, fragment);
        transaction.commit();
    }
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new My2015ChildFragment());
        fragments.add(new ZGFragment());
        fragments.add(new HistoryFragment());
        fragments.add(new UpLoadFragment());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
