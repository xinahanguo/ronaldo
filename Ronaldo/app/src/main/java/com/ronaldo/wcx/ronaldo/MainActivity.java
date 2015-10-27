package com.ronaldo.wcx.ronaldo;

import android.os.Bundle;
import android.view.View;

import com.ronaldo.wcx.bean.EventCenter;
import com.ronaldo.wcx.net.NetUtils;

import butterknife.ButterKnife;

/**
 * setNavigationIcon和setLogo设置Toolbar的icon
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {
        return ButterKnife.findById(this,R.id.vp_main);
    }

    @Override
    protected void initViewsAndEvents() {//初始化View

    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {//判断状态栏是否透明
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {    //是否绑定EventBus
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }
}
