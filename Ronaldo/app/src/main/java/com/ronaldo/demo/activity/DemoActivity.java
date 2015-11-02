package com.ronaldo.demo.activity;

import android.support.v4.view.ViewPager;

import com.android.ronaldo.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;
/**
 * Created by wcx on 2015/11/3.
 */
public class DemoActivity extends BaseActivity{

    @Bind(R.id.viewpagertab)
    SmartTabLayout viewpagertab;

    @Bind(R.id.fragment_images_pager)
    ViewPager mPager;

    @Override
    protected void initView() {
        FragmentPagerItemAdapter adapter =
                new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(this)
                        .create());
        mPager.setAdapter(adapter);
        viewpagertab.setViewPager(mPager);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_piclook;
    }

    @Override
    protected void getBundleExtras() {

    }
}
