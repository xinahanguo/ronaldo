package com.ronaldo.demo.activity;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ronaldo.R;
import com.ronaldo.demo.presenter.SplashPresenter;
import com.ronaldo.demo.view.SplashView;

/**
 * Created by wcx on 2015/11/2.
 */
public class SplashActivity extends BaseActivity implements SplashView{

    private ImageView splashImage;
    private TextView splashCopyright;

    @Override
    protected void initView() {
        splashImage = (ImageView) findViewById(R.id.splash_image);
        splashCopyright = (TextView) findViewById(R.id.splash_app_copyright);
        SplashPresenter splashPresenter = new SplashPresenter(this, this);
        splashPresenter.init();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void getBundleExtras() {

    }

    @Override
    public void animateBackgroundImage(Animation animation) {
        splashImage.startAnimation(animation);
    }

    @Override
    public void initializeViews(String versionName, String copyright, int backgroundResId) {
        Drawable drawable = getResources().getDrawable(backgroundResId);
        splashImage.setImageDrawable(drawable);
        splashCopyright.setText(versionName + "  " + copyright);
    }

    @Override
    public void initializeUmengConfig() {

    }

    @Override
    public void gotoNextActivity() {
        readyGoThenKill(MainActivity.class);
    }
}
