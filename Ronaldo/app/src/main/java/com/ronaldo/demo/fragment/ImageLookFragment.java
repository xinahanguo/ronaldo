package com.ronaldo.demo.fragment;


import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.ronaldo.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ronaldo.demo.adapter.ImageLookFragmentAdapter;
import com.ronaldo.demo.domain.BaseEntity;
import com.ronaldo.demo.presenter.ImageLookPresenter;
import com.ronaldo.demo.view.ImageLookView;

import java.util.List;

/**
 * Created by wcx on 2015/11/10.
 */
public class ImageLookFragment extends BaseFragment implements ImageLookView{

    private SmartTabLayout smartTab;
    private ViewPager vpImagelook;

    @Override
    protected void initView(View view) {
        smartTab = (SmartTabLayout) view.findViewById(R.id.smart_tab);
        vpImagelook = (ViewPager) view.findViewById(R.id.vp_imagelook);
        ImageLookPresenter imageLookPresenter = new ImageLookPresenter(mContext, this);
        imageLookPresenter.init();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_imagelook;
    }

    @Override
    protected void onFirstUserVisible() {//pager页面首次可见时

    }

    @Override
    protected void onFirstUserInvisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    public void initializePagerViews(List<BaseEntity> categoryList) {
        if (null!= categoryList&&!categoryList.isEmpty()) {
            vpImagelook.setOffscreenPageLimit(categoryList.size());
            vpImagelook.setAdapter(new ImageLookFragmentAdapter(getSupportFragmentManager(), categoryList));
            smartTab.setViewPager(vpImagelook);
        }
    }
}
