package com.ronaldo.demo.view;

import com.ronaldo.demo.domain.ImagesListEntity;
import com.ronaldo.demo.domain.ResponseImagesListEntity;
import com.ronaldo.demo.view.base.BaseView;

/**
 * Created by wcx on 2015/11/12.
 */
public interface ImageListView extends BaseView{//查看图片的列表
    void refreshListData(ResponseImagesListEntity responseImagesListEntity);

    void addMoreListData(ResponseImagesListEntity responseImagesListEntity);

    void navigateToImagesDetail(int position, ImagesListEntity entity, int x, int y, int width, int height);
}
