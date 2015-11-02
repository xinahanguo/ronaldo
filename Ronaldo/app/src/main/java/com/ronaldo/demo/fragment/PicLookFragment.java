package com.ronaldo.demo.fragment;


import android.support.v4.view.ViewPager;

import com.android.ronaldo.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import butterknife.Bind;

/**
 * Created by wcx on 2015/11/2.
 */
public class PicLookFragment extends BaseFragment{

    @Bind(R.id.viewpagertab)
    SmartTabLayout viewpagertab;

    @Bind(R.id.fragment_images_pager)
    ViewPager images_pager;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_piclook;
    }

    @Override
    protected void initView() {

    }
}
