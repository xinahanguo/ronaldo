package com.ronaldo.wcx.ronaldo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ronaldo.wcx.bean.EventCenter;
import com.ronaldo.wcx.loading.VaryViewHelperController;
import com.ronaldo.wcx.manage.SystemBarTintManager;
import com.ronaldo.wcx.net.NetUtils;
import com.ronaldo.wcx.utils.BaseAppManager;
import com.ronaldo.wcx.utils.CommonUtils;
import com.ronaldo.wcx.utils.SmartBarUtils;
import com.ypy.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 *  Created by wcx on 2015/10/26.
 *
 *  Think Android
 *  是一个免费的开源的、简易的、遵循Apache2开源协议发布的Android开发框架，其开发宗旨是简单、快速的进行Android应用程序的开发，
 *  包含Android  mvc、简易sqlite orm、ioc模块、封装Android  httpclitent的http模块,具有快速构建文件缓存功能，无需考虑缓存文件的格式，
 *  都可以非常轻松的实现缓存，它还基于文件缓存模块实现了图片缓存功能，在android中加载的图片的时候，
 *  对oom的问题，和对加载图片错位的问题都轻易解决。他还包括了一个手机开发中经常应用的实用工具类，如日志管理，配置文件管理，android下载器模块，
 *  网络切换检测等等工具。
 *
 *  Android butterknife  //注解框架
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    protected static String TAG_LOG = null;

    protected int mScreenWidth = 0;
    protected int mScreenHeight = 0;
    protected float mScreenDensity = 0.0f;

    protected Context mContext = null;

    public enum TransitionMode {
        LEFT, RIGHT, TOP, BOTTOM, SCALE, FADE        /**overridePendingTransition表示activity之间的动画*/
    }

    private VaryViewHelperController mVaryViewHelperController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (toggleOverridePendingTransition()) {//判断是否要有跳转动画
            switch (getOverridePendingTransitionMode()) {//根据返回的类型，执行相应的动画跳转
                case LEFT:
                    overridePendingTransition(R.anim.left_in,R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in,R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in,R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in,R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in,R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
            }
        }
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (null!=extras) {
            getBundleExtras(extras);
        }
        if(isBindEventBusHere()) {//是否绑定EventBus
            EventBus.getDefault().register(this);//注册EventBus
        }

        SmartBarUtils.hide(getWindow().getDecorView());//去除title

        setTranslucentStatus(isApplyStatusBarTranslucency());//设置透明的状态  isApplyStatusBarTranslucency()状态栏是否透明
        mContext = this;
        TAG_LOG = this.getClass().getSimpleName();
        BaseAppManager.getInstance().addActivity(this);//把该activity添加到manager中

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //得到屏幕的密度，宽，高
        mScreenDensity = displayMetrics.density;
        mScreenHeight = displayMetrics.heightPixels;
        mScreenWidth = displayMetrics.widthPixels;

        if(getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        initViewsAndEvents();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);//使用注解的方式注入对象
        if (null!=getLoadingTargetView()) {//loadingView不为null
            mVaryViewHelperController = new VaryViewHelperController(getLoadingTargetView());
        }
    }

    @Override
    public void finish() {
        super.finish();
        BaseAppManager.getInstance().removeActivity(this);
        if (toggleOverridePendingTransition()) {
            switch (getOverridePendingTransitionMode()) {
                case LEFT:
                    overridePendingTransition(R.anim.left_in,R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in,R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in,R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in,R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in,R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
//        NetStateReceiver.removeRegisterObserver(mNetChangeObserver);
        if (isBindEventBusHere()) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 获取bundle的数据
     */
    protected abstract void getBundleExtras(Bundle extras);

    /**
     * 获取layout的id
     */
    protected abstract int getContentViewLayoutID();

    /**
     *EventCenter--->EventBus即将post数据的对象
     */
    protected abstract void onEventComming(EventCenter eventCenter);

    /**
     * 获取加载的View
     */
    protected abstract View getLoadingTargetView();

    /**
     * 初始化View和events
     */
    protected abstract void initViewsAndEvents();

    /**
     * network connected    网络连接
     */
    protected abstract void onNetworkConnected(NetUtils.NetType type);

    /**
     * network disconnected     网络断开连接
     */
    protected abstract void onNetworkDisConnected();

    /**
     * 判断状态栏是否透明
     */
    protected abstract boolean isApplyStatusBarTranslucency();

    /**
     * 是否绑定EventBus
     */
    protected abstract boolean isBindEventBusHere();

    /**
     * 跳转动画的开关
     */
    protected abstract boolean toggleOverridePendingTransition();

    /**
     *获取跳转动画的mode
     */
    protected abstract TransitionMode getOverridePendingTransitionMode();

    /**
     * startActivity
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * show toast
     */
    protected void showToast(String msg) {
        if (null != msg && !CommonUtils.isEmpty(msg)) {
            Snackbar.make(getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT).show();
        }
    }


    //四种不同的页面，分别是loading,empty,error,networkerror
    /**
     * toggle show loading
     */
    protected void toggleShowLoading(boolean toggle, String msg) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mVaryViewHelperController.showLoading(msg);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show empty
     * @param toggle
     */
    protected void toggleShowEmpty(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }
        if (toggle) {
            mVaryViewHelperController.showEmpty(msg, onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show error
     *
     * @param toggle
     */
    protected void toggleShowError(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mVaryViewHelperController.showError(msg, onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show network error
     */
    protected void toggleNetworkError(boolean toggle, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mVaryViewHelperController.showNetworkError(onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    public void onEventMainThread(EventCenter eventCenter) {
        if (null != eventCenter) {
            onEventComming(eventCenter);
        }
    }

    /**
     * SystemBarTint:黑色的通知栏，可以变成与APP主题相一致的颜色    SystemBarTintManager
     */
    protected void setSystemBarTintDrawable(Drawable tintDrawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            if (tintDrawable != null) {
                mTintManager.setStatusBarTintEnabled(true);
                mTintManager.setTintDrawable(tintDrawable);
            } else {
                mTintManager.setStatusBarTintEnabled(false);
                mTintManager.setTintDrawable(null);
            }
        }

    }

    /**
     * set status bar translucency
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }
}
