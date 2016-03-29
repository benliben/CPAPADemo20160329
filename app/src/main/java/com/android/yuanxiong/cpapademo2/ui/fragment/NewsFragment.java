package com.android.yuanxiong.cpapademo2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.ui.adapter.BannerCommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 李远雄 on 2016/3/18.
 * 新闻
 */
public class NewsFragment extends BaseFragment {

    @Bind(R.id.newsRecyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.newsListView)
    ListView mListView;


    private View rootView;
    private List<ImageView> mImageViews;
    private BannerCommonAdapter mBannerCommonAdapter;
    private int[] imgsRes = {R.mipmap.pic_1, R.mipmap.pic_2, R.mipmap.pic_3, R.mipmap.pic_4, R.mipmap.pic_5};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_news, container, false);
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
        initRecycle();
        View viewholder = LayoutInflater.from(getActivity()).inflate(R.layout.news_head, null);
        ViewHolder holder = new ViewHolder(viewholder);
        mListView.addHeaderView(viewholder);
        initBanner(holder.mViewPager);
    }

    private void initBanner(ViewPager mViewPager) {
        initBannerView();
        mBannerCommonAdapter = new BannerCommonAdapter(getActivity(), mImageViews);
        mViewPager.setAdapter(mBannerCommonAdapter);
    }

    private void initBannerView() {
        mImageViews = new ArrayList<>();
        for (int i : imgsRes) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(i);
            mImageViews.add(imageView);
        }
    }

    private void initRecycle() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    static class ViewHolder {
        @Bind(R.id.newsViewPager)
        ViewPager mViewPager;
        @Bind(R.id.newsTextView)
        TextView mTextView;
        @Bind(R.id.newsProgressBsr)
        ProgressBar mProgressBsr;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
