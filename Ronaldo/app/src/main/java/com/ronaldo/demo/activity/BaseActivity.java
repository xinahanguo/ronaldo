package com.ronaldo.demo.activity;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by wcx on 2015/11/2.
 */
public  abstract class BaseActivity extends BaseAppCompatActivity{
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }
}
