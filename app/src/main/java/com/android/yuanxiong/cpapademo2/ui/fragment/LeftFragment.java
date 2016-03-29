package com.android.yuanxiong.cpapademo2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;
import com.android.yuanxiong.cpapademo2.ui.activity.MainActivity;
import com.android.yuanxiong.cpapademo2.ui.adapter.LeftFragmentAdapter;
import com.android.yuanxiong.cpapademo2.ui.widget.FragmentContainer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 李远雄 on 2016/3/18.
 * 左边菜单栏
 */
public class LeftFragment extends BaseFragment {
    @Bind(R.id.leftListView)
    ListView leftListView;
    private View rootView;
    private List<LeftTagModel> models;
    private LeftFragmentAdapter fragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_left, container, false);
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initView() {
        leftListView.setAdapter(fragmentAdapter);
        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragmentAdapter.setChoosePosition(position);
                ((MainActivity)getActivity()).switchContentFragment(models.get(position));
            }
        });
    }

    private void initData() {
        initModel();
        fragmentAdapter = new LeftFragmentAdapter(models, getActivity());
    }

    private void initModel() {
        models=getTagModelFromMap();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.leftTextView)
    public void onClick() {
    }

    public List<LeftTagModel> getTagModelFromMap() {
        List<LeftTagModel> list = new ArrayList<>();
        list.add(FragmentContainer.getTagModel().get(HomeFragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(NewsFragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(My2016Fragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(ShopFragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(AuctionFragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(MarketFragment.class.getSimpleName()));
        return list;

    }
}
