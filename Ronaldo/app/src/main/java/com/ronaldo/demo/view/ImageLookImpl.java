package com.ronaldo.demo.view;

import android.content.Context;

import com.android.ronaldo.R;
import com.ronaldo.demo.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public class ImageLookImpl implements ImageLook{
    @Override
    public List<BaseEntity> getCommonCategoryList(Context context) {
        List<BaseEntity> resultData = new ArrayList<>();
        String[] imagesCategoryArray = context.getResources().getStringArray(R.array.main_data);
        resultData.add(new BaseEntity(imagesCategoryArray[0], imagesCategoryArray[0]));
        resultData.add(new BaseEntity(imagesCategoryArray[1], imagesCategoryArray[1]));
        resultData.add(new BaseEntity(imagesCategoryArray[2], imagesCategoryArray[2]));
        resultData.add(new BaseEntity(imagesCategoryArray[3], imagesCategoryArray[3]));
        resultData.add(new BaseEntity(imagesCategoryArray[4], imagesCategoryArray[4]));
        resultData.add(new BaseEntity(imagesCategoryArray[5], imagesCategoryArray[5]));
        return resultData;
    }
}
