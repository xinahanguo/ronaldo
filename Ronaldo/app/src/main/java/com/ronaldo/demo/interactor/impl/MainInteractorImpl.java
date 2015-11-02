package com.ronaldo.demo.interactor.impl;

import android.content.Context;

import com.android.ronaldo.R;
import com.ronaldo.demo.bean.NavigationEntity;
import com.ronaldo.demo.fragment.BaseFragment;
import com.ronaldo.demo.interactor.MainInteractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcx on 2015/11/2.
 */
public class MainInteractorImpl  implements MainInteractor{

    @Override
    public List<BaseFragment> getPagerFragments() {
        return null;
    }

    @Override
    public List<NavigationEntity> getNavigationListData(Context context) {
        List<NavigationEntity> navigationEntities = new ArrayList<>();
        String[] navigationArrays = context.getResources().getStringArray(R.array.left_listdata);
        navigationEntities.add(new NavigationEntity("", navigationArrays[0], R.mipmap.ic_picture));
        navigationEntities.add(new NavigationEntity("", navigationArrays[1], R.mipmap.ic_video));
        navigationEntities.add(new NavigationEntity("", navigationArrays[2], R.mipmap.ic_music));
        return navigationEntities;
    }
}
