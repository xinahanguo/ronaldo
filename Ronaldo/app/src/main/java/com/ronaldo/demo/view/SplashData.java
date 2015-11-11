package com.ronaldo.demo.view;

import android.content.Context;
import android.view.animation.Animation;

/**
 * Created by wcx on 2015/11/11.
 */
public interface SplashData {
    Animation getSplashBackgroundAnimation(Context context);
    String getVersionName(Context context);
    int getBackgroundDrawableId();
    String getCopyRirht(Context context);
}
