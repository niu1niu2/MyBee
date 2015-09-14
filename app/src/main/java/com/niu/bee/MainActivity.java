package com.niu.bee;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.niu.bee.fragment.BuyFragment;
import com.niu.bee.fragment.HomeFragment;
import com.niu.bee.fragment.MessageFragment;
import com.niu.bee.fragment.UserFragment;
import com.niu.bee.utils.FragmentTabUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentTabUtils.OnRgsExtraCheckedChangedListener {
    @ViewInject(R.id.rg_main_footers)
    private RadioGroup rgs;
    private List<Fragment> fragments;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(HomeFragment.getInstance());
        fragments.add(BuyFragment.getInstance());
        fragments.add(MessageFragment.getInstance());
        fragments.add(UserFragment.getInstance());
        FragmentTabUtils utils = new FragmentTabUtils(getSupportFragmentManager(),fragments,R.id.fl_main_container,rgs);
        utils.setOnRgsExtraCheckedChangedListener(this);
    }

    @Override
    public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exit();
    }
  //退出程序的方法 通常连续点击来退出
    private void exit() {
        if ((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(getApplicationContext(),"再按一次退出",Toast.LENGTH_LONG).show();
            exitTime = System.currentTimeMillis();
        }else {
            finish();
        }
    }
}
