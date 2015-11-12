package com.ronaldo.demo.view;

import android.content.Context;

import com.ronaldo.demo.domain.LeftListEntity;
import com.ronaldo.demo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public interface HomeData {

    List<BaseFragment> getLeftFragment();

    List<LeftListEntity> getLeftListData(Context context);
}
