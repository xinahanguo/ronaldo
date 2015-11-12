package com.ronaldo.demo.presenter;

import com.ronaldo.demo.domain.ImagesListEntity;

/**
 * Created by wcx on 2015/11/12.
 */
public interface ImageListPresenter {
    void loadListData(String requestTag, int event_tag, String keywords, int page, boolean isSwipeRefresh);
    void onItemClickListener(int position, ImagesListEntity entity, int x, int y, int width, int height);
}
