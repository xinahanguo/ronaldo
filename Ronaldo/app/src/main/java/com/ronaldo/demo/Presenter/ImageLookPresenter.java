package com.ronaldo.demo.presenter;

import android.content.Context;

import com.ronaldo.demo.view.ImageLookImpl;
import com.ronaldo.demo.view.ImageLookView;

/**
 * Created by wcx on 2015/11/12.
 */
public class ImageLookPresenter implements Presenter{

    Context mcontext;
    ImageLookView mImageLookView;
    ImageLookImpl imageLook;

    public ImageLookPresenter(Context context,ImageLookView imageLookView){
        mcontext=context;
        mImageLookView=imageLookView;
        imageLook = new ImageLookImpl();
    }


    @Override
    public void init() {
        mImageLookView.initializePagerViews(imageLook.getCommonCategoryList(mcontext));
    }
}
