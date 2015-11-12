package com.ronaldo.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ronaldo.demo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public class CommonFragmentAdapter extends FragmentPagerAdapter{
    List<BaseFragment> mFragments;
    public CommonFragmentAdapter(FragmentManager fm,List<BaseFragment> fragments) {
        super(fm);
        mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragments != null && position > -1 && position < mFragments.size()) {
            return mFragments.get(position);
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return null != mFragments ? mFragments.size() : 0;
    }
}
