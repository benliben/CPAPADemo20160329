package com.android.yuanxiong.cpapademo2.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.ui.activity.CollectActivity;
import com.android.yuanxiong.cpapademo2.ui.activity.LoginActivity;
import com.android.yuanxiong.cpapademo2.ui.activity.SetActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 李远雄 on 2016/3/18.
 * 左侧菜单栏
 */
public class RightFragment extends BaseFragment {
    @Bind(R.id.rightPhoto)
    ImageView rightPhoto;
    @Bind(R.id.rightLogin)
    TextView rightLogin;
    @Bind(R.id.rightCollect)
    TextView rightCollect;
    @Bind(R.id.rightSet)
    TextView rightSet;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_right, container, false);
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rightPhoto, R.id.rightLogin, R.id.rightCollect, R.id.rightSet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rightPhoto:
                Toast.makeText(getActivity(),"你点击了头像",Toast.LENGTH_LONG).show();
                break;
            case R.id.rightLogin:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.rightCollect:
                startActivity(new Intent(getActivity(),CollectActivity.class));
                break;
            case R.id.rightSet:
                startActivity(new Intent(getActivity(),SetActivity.class));
                break;
        }
    }
}
