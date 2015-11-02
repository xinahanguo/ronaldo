package com.ronaldo.demo.present;

import android.content.Context;

import com.ronaldo.demo.interactor.ImageLookInteractor;
import com.ronaldo.demo.interactor.impl.ImageLookInteractorImpl;
import com.ronaldo.demo.view.ImageLookView;

/**
 * Created by wcx on 2015/11/4.
 */
public class ImageLookPresent implements Present{
    private Context mContext;
    private ImageLookInteractor mCommonContainerInteractor;
    private ImageLookView mCommonContainerView;

    public ImageLookPresent(Context context, ImageLookView commonContainerView) {
        mContext = context;
        mCommonContainerView = commonContainerView;
        mCommonContainerInteractor = new ImageLookInteractorImpl();
    }

    @Override
    public void initialized() {
        mCommonContainerView.initializePagerViews(mCommonContainerInteractor.getCommonCategoryList(mContext));
    }
}
