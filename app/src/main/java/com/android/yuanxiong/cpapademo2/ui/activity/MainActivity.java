package com.android.yuanxiong.cpapademo2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;
import com.android.yuanxiong.cpapademo2.ui.fragment.LeftFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.RightFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.mainText)
    TextView mainText;
    @Bind(R.id.left)
    FrameLayout left;
    @Bind(R.id.right)
    FrameLayout right;
    @Bind(R.id.mainDrawerLayout)
    DrawerLayout mainDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.left, new LeftFragment());
        transaction.replace(R.id.right, new RightFragment());
        transaction.commit();
    }

    @OnClick({R.id.mainLeft, R.id.mainRight})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainLeft:
                mainDrawerLayout.openDrawer(left);
                break;
            case R.id.mainRight:
                mainDrawerLayout.openDrawer(right);
                break;
        }
    }

    public void switchContentFragment(LeftTagModel model){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.replace(R.id.mainFrameLayout, model.getFragment());
        transaction.commit();
        mainDrawerLayout.closeDrawers();
      switchTitle(model.getName());
    }

    private void switchTitle(String name) {
        mainText.setText(name);
    }
}
