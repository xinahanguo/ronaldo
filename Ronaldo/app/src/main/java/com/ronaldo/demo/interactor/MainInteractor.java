package com.ronaldo.demo.interactor;

import android.content.Context;

import com.ronaldo.demo.bean.NavigationEntity;
import com.ronaldo.demo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by wcx on 2015/11/2.
 */
public interface MainInteractor {
    List<BaseFragment> getPagerFragments();
    List<NavigationEntity> getNavigationListData(Context context);
}
