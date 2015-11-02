package com.ronaldo.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ronaldo.demo.bean.BaseEntity;
import com.ronaldo.demo.fragment.SubImageLookFragment;

import java.util.List;

/**
 * Created by wcx on 2015/11/4.
 */
public class ImageLookAdapter extends FragmentPagerAdapter{
    private List<BaseEntity> mCategoryList = null;

    public ImageLookAdapter(FragmentManager fm,List<BaseEntity> categoryList) {
        super(fm);
        mCategoryList = categoryList;
    }

    @Override
    public Fragment getItem(int position) {
        return new SubImageLookFragment();
    }

    @Override
    public int getCount() {
        return null != mCategoryList ? mCategoryList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null != mCategoryList ? mCategoryList.get(position).getName() : null;
    }
}
