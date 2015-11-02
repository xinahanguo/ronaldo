package com.ronaldo.demo.interactor;

import android.content.Context;

import com.ronaldo.demo.bean.BaseEntity;

import java.util.List;

/**
 * Created by wcx on 2015/11/4.
 */
public interface ImageLookInteractor {
    List<BaseEntity> getCommonCategoryList(Context context);
}
