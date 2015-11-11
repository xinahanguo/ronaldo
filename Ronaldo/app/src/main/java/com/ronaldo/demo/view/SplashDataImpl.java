package com.ronaldo.demo.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.android.ronaldo.R;
import java.util.Calendar;

/**
 * Created by wcx on 2015/11/11.
 */
public class SplashDataImpl implements SplashData{
    String versionName;

    @Override
    public Animation getSplashBackgroundAnimation(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.sp_start);
        return animation;
    }

    @Override
    public String getVersionName(Context context) {
        try {
            versionName=context.getPackageManager().getPackageInfo(context.getPackageName(),0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    @Override
    public int getBackgroundDrawableId() {
        int resId;
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 12) {
            resId = R.mipmap.morning;
        } else if (hour > 12 && hour <= 18) {
            resId = R.mipmap.afternoon;
        } else {
            resId = R.mipmap.night;
        }
        return resId;
    }

    @Override
    public String getCopyRirht(Context context) {
        String string = context.getResources().getString(R.string.splash_copyright);
        return string;
    }
}
