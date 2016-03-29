package com.android.yuanxiong.cpapademo2.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;
import com.android.yuanxiong.cpapademo2.ui.activity.MainActivity;
import com.android.yuanxiong.cpapademo2.ui.adapter.BannerCommonAdapter;
import com.android.yuanxiong.cpapademo2.ui.widget.FragmentContainer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 李远雄 on 2016/3/18.
 * 视野
 */
public class HomeFragment extends BaseFragment {

    @Bind(R.id.mainViewPager)
    ViewPager mainViewPager;
    @Bind(R.id.mainProgressBar)
    ContentLoadingProgressBar mainProgressBar;
    @Bind(R.id.mainText)
    TextView mainText;
    @Bind(R.id.mainCheck)
    CheckBox mainCheck;
    @Bind(R.id.mainGroup)
    RadioGroup mainGroup;
    private View rootView;

    private PageRunHandler  mPageRunHandler;
    private List<ImageView> imageViews;
    private int[] imgsRes={R.mipmap.pic_5,R.mipmap.pic_4,R.mipmap.pic_3,R.mipmap.pic_2,R.mipmap.pic_1};
    private BannerCommonAdapter mBannerCommonAdapter;
    private static final int BANNER_CHANGE_TIME=3000;//滑动时间


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*点击事件*/
        initData();
        /*广告滑动*/
        initView();
    }

    /***************************************************************************************************
     * 下方按钮点击事件
     */
    private void initData() {
        mainGroup= (RadioGroup) rootView.findViewById(R.id.mainGroup);
        mainViewPager= (ViewPager) rootView.findViewById(R.id.mainViewPager);
        mainGroup.setOnCheckedChangeListener(mChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mChangeListener=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            LeftTagModel model=null;
            switch (checkedId) {
                case R.id.mainMy2015:
                    model = FragmentContainer.getTagModel().get(My2016Fragment.class.getSimpleName());
                    break;
                case R.id.mainShop:
                    model = FragmentContainer.getTagModel().get(ShopFragment.class.getSimpleName());
                    break;
                case R.id.mainAuction:
                    model = FragmentContainer.getTagModel().get(AuctionFragment.class.getSimpleName());
                    break;
                case R.id.mainMarket:
                    model = FragmentContainer.getTagModel().get(MarketFragment.class.getSimpleName());
                    break;
            }
            ((MainActivity)getActivity()).switchContentFragment(model);
        }
    };

    /**
     * 结束
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({ R.id.mainImage,  R.id.mainCheck,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainImage:
                break;
            case R.id.mainCheck:
                break;
        }
    }

    /**
     * 下方按钮点击事件
     * *************************************************************************************************
     */



    /******************************************************************************************************
     *  广告滑动
     */


    private void initView() {
        initBanner();
    }

    private void initBanner() {
        initBannerView();//图片数据
        mBannerCommonAdapter = new BannerCommonAdapter(getActivity(), imageViews);
        mainViewPager.setAdapter(mBannerCommonAdapter);
        mainViewPager.setCurrentItem(Integer.MAX_VALUE / 2);//设置起始位置为最大值的一半
//        startBannerRun();//开启滑动
    }

    /**
     * 图片资源
     */
    private void initBannerView() {
        imageViews = new ArrayList<>();
        for (int i : imgsRes) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(i);
            imageViews.add(imageView);
        }
    }
    /**
     * 处理翻页
     */
    class PageRunHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    int indexPosition = mainViewPager.getCurrentItem();
                    mainViewPager.setCurrentItem(indexPosition + 1);
                    break;
            }
        }
    }

    /**
     * 初始化滑动广告栏
     */
    private void startBannerRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mPageRunHandler.sendEmptyMessageDelayed(0, BANNER_CHANGE_TIME);
            }
        }).start();
    }


    /**
     *  广告滑动
     *  ****************************************************************************************************
     */
}

