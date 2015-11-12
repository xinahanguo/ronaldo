package com.ronaldo.demo.view;


import com.ronaldo.demo.domain.LeftListEntity;
import com.ronaldo.demo.fragment.BaseFragment;
import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public interface HomeView {
    void initializeViews(List<BaseFragment> fragments, List<LeftListEntity> navigationList);
}
