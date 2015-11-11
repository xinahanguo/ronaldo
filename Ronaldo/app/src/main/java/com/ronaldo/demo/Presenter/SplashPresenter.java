package com.ronaldo.demo.presenter;

import android.content.Context;
import android.view.animation.Animation;

import com.ronaldo.demo.view.SplashDataImpl;
import com.ronaldo.demo.view.SplashView;

/**
 * Created by wcx on 2015/11/11.
 */
public class SplashPresenter implements Presenter{

    Context mcontext;
    SplashView mSplashView;
    SplashDataImpl splashData;

    public SplashPresenter(Context context,SplashView splashView){
        mcontext=context;
        mSplashView=splashView;
        splashData=new SplashDataImpl();
    }

    @Override
    public void init() {
        mSplashView.initializeUmengConfig();
        mSplashView.initializeViews(splashData.getVersionName(mcontext), splashData.getCopyRirht(mcontext), splashData.getBackgroundDrawableId());
        Animation animation =
                splashData.getSplashBackgroundAnimation(mcontext);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mSplashView.gotoNextActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashView.animateBackgroundImage(animation);
    }
}
