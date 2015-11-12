package com.ronaldo.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ronaldo.demo.domain.BaseEntity;
import com.ronaldo.demo.fragment.ImageSubLookFragment;

import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public class ImageLookFragmentAdapter extends FragmentPagerAdapter {
    List<BaseEntity> mCategoryList;
    public ImageLookFragmentAdapter(FragmentManager fm,List<BaseEntity> categoryList) {
        super(fm);
        mCategoryList=categoryList;
    }

    @Override
    public Fragment getItem(int position) {
        return new ImageSubLookFragment();
    }

    @Override
    public int getCount() {
        return mCategoryList.size();
    }
}
