package com.ronaldo.demo.view;

import com.ronaldo.demo.bean.NavigationEntity;
import com.ronaldo.demo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by wcx on 2015/11/2.
 */
public interface MainView {
    void initializeViews(List<BaseFragment> fragments, List<NavigationEntity> navigationList);
}
