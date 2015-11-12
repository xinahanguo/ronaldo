package com.ronaldo.demo.view;

import android.content.Context;

import com.android.ronaldo.R;
import com.ronaldo.demo.domain.LeftListEntity;
import com.ronaldo.demo.fragment.BaseFragment;
import com.ronaldo.demo.fragment.ImageLookFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public class HomeDataImpl implements HomeData {
    @Override
    public List<BaseFragment> getLeftFragment() {
        List<BaseFragment> lists=new ArrayList<>();
        lists.add(new ImageLookFragment());
        return lists;
    }

    @Override
    public List<LeftListEntity> getLeftListData(Context context) {
        List<LeftListEntity> navigationEntities = new ArrayList<>();
        String[] navigationArrays = context.getResources().getStringArray(R.array.left_data);
        navigationEntities.add(new LeftListEntity("", navigationArrays[0], R.mipmap.madraid));
        navigationEntities.add(new LeftListEntity("", navigationArrays[1], R.mipmap.manunited));
        navigationEntities.add(new LeftListEntity("", navigationArrays[2], R.mipmap.chelsea));
        return navigationEntities;
    }
}
