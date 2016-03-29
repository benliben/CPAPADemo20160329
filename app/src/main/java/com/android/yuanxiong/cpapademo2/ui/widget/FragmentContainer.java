package com.android.yuanxiong.cpapademo2.ui.widget;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.android.yuanxiong.cpapademo2.model.LeftTagModel;
import com.android.yuanxiong.cpapademo2.ui.fragment.AuctionFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.HomeFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.LeftFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.MarketFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.My2016Fragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.NewsFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by 李远雄 on 2016/3/22.
 */
public class FragmentContainer {

    private FragmentContainer() {
    }
    private static Map<String,LeftTagModel> getTagModel;

    public static Map<String, LeftTagModel> getTagModel() {
        if (getTagModel == null) {
            getTagModel = new HashMap<>();
            getTagModel.put(HomeFragment.class.getSimpleName(),createModel("视野",new HomeFragment()));
            getTagModel.put(NewsFragment.class.getSimpleName(),createModel("新闻",new NewsFragment()));
            getTagModel.put(My2016Fragment.class.getSimpleName(),createModel("我的2016",new My2016Fragment()));
            getTagModel.put(ShopFragment.class.getSimpleName(),createModel("器材商城",new ShopFragment()));
            getTagModel.put(AuctionFragment.class.getSimpleName(),createModel("拍卖收藏",new AuctionFragment()));
            getTagModel.put(MarketFragment.class.getSimpleName(),createModel("图片市场",new MarketFragment()));

        }
        return getTagModel;
    }

    private static LeftTagModel createModel(String name, Fragment fragment) {
        LeftTagModel list=new LeftTagModel();
        list.setName(name);
        list.setFragment(fragment);
        Log.i("lyx", "3333333333333333333333333333333: "+list);
        return list;
    }


}