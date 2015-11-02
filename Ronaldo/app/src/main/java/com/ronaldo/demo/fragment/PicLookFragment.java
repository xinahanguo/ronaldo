package com.ronaldo.demo.fragment;


import android.support.v4.view.ViewPager;

import com.android.ronaldo.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ronaldo.demo.adapter.ImageLookAdapter;
import com.ronaldo.demo.bean.BaseEntity;
import com.ronaldo.demo.present.ImageLookPresent;
import com.ronaldo.demo.view.ImageLookView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by wcx on 2015/11/2.
 */
public class PicLookFragment extends BaseFragment implements ImageLookView{

    @Bind(R.id.viewpagertab)
    SmartTabLayout mViewpagertab;

    @Bind(R.id.fragment_images_pager)
    ViewPager mViewPager;

    @Override
    protected void onFirstUserVisible() {
        ImageLookPresent imageLookPresent = new ImageLookPresent(mContext, this);
        imageLookPresent.initialized();
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_piclook;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initializePagerViews(List<BaseEntity> categoryList) {
        if (null != categoryList && !categoryList.isEmpty()) {
            mViewPager.setOffscreenPageLimit(categoryList.size());//指定ViewPager加载的页数
            mViewPager.setAdapter(new ImageLookAdapter(getSupportFragmentManager(), categoryList));
            mViewpagertab.setViewPager(mViewPager);
        }
    }
}
