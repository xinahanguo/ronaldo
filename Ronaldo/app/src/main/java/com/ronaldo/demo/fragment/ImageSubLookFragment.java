package com.ronaldo.demo.fragment;

import android.view.View;

import com.ronaldo.demo.domain.ImagesListEntity;
import com.ronaldo.demo.domain.ResponseImagesListEntity;
import com.ronaldo.demo.view.ImageListView;

/**
 * Created by wcx on 2015/11/12.
 */
public class ImageSubLookFragment extends BaseFragment implements ImageListView{
    @Override
    protected void initView(View view) {
    }

    @Override
    protected int getContentViewLayoutID() {
        return 0;
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onFirstUserInvisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }


    //==============================================================================
    @Override
    public void refreshListData(ResponseImagesListEntity responseImagesListEntity) {

    }

    @Override
    public void addMoreListData(ResponseImagesListEntity responseImagesListEntity) {

    }

    @Override
    public void navigateToImagesDetail(int position, ImagesListEntity entity, int x, int y, int width, int height) {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showException(String msg) {

    }

    @Override
    public void showNetError() {

    }
}
