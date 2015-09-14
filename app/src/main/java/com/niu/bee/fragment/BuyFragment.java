package com.niu.bee.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.niu.bee.R;
import com.niu.bee.adapter.BuyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyFragment extends Fragment implements ViewPager.OnPageChangeListener, CompoundButton.OnCheckedChangeListener {
    @ViewInject(R.id.rg_buy_rgs)
    private RadioGroup rgs;
    @ViewInject(R.id.vp_buy_contanrs)
    private ViewPager viewPager;
    private BuyViewPagerAdapter buyViewPagerAdapter;
    private List<Fragment> fragments;
    private RadioButton[] rbs;
    private View view;
    public BuyFragment() {
    }

    public static BuyFragment getInstance() {
        BuyFragment buy = new BuyFragment();
        return buy;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_buy, container, false);
        ViewUtils.inject(this,view);
        initView();
        return view;
    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(PublishFragment.getInstance());
        fragments.add(ListsFragment.getInstance());
        buyViewPagerAdapter = new BuyViewPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(buyViewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        getRadioButton();
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {
        rbs[position].setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void getRadioButton() {
        rbs = new RadioButton[rgs.getChildCount()];
        for (int i = 0; i < rbs.length ; i++) {
           rbs[i] = (RadioButton) rgs.getChildAt(i);
            rbs[i].setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (rbs[0].isChecked()){
            viewPager.setCurrentItem(0);
        }else if (rbs[1].isChecked()){
            viewPager.setCurrentItem(1);
        }
    }
}
