package com.ronaldo.demo.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.android.ronaldo.R;
import butterknife.Bind;

/**
 * Created by wcx on 2015/11/2.
 */
public class SplashActivity extends BaseActivity{

    @Bind(R.id.splash_image)
    ImageView splashImage;

    private Drawable mDraeables[]=new Drawable[1];
    private int images_id[]={R.mipmap.sp_1};
    private Animation mAnimations[]=new Animation[1];

    @Override
    protected void initView() {
        for (int i = 0; i <mDraeables.length; i++) {
            mDraeables[i]=getResources().getDrawable(images_id[i]);
        }
        mAnimations[0]= AnimationUtils.loadAnimation(mContext, R.anim.sp_start);
        for (int i = 0; i <mAnimations.length; i++) {
            mAnimations[i].setDuration(2000);
            mAnimations[i].setAnimationListener(new SplashImageAnimationListener(i));
        }
        splashImage.setImageDrawable(mDraeables[0]);
        splashImage.startAnimation(mAnimations[0]);
    }


    class SplashImageAnimationListener implements Animation.AnimationListener{
        private int position;
        public SplashImageAnimationListener(int position){
            this.position=position;
        }
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void getBundleExtras() {

    }
}
