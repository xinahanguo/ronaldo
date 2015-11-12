package com.ronaldo.demo.view;

import com.ronaldo.demo.domain.BaseEntity;

import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public interface ImageLookView {
    void initializePagerViews(List<BaseEntity> categoryList);
}
