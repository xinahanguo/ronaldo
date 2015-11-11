package com.ronaldo.demo.view;

import android.view.animation.Animation;

/**
 * Created by wcx on 2015/11/11.
 */
public interface SplashView {
    void animateBackgroundImage(Animation animation);
    void initializeViews(String versionName,String copyright,int backgroundResId);
    void initializeUmengConfig();
    void gotoNextActivity();
}
