package com.ronaldo.wcx.ronaldo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ronaldo.wcx.RonaldoApplication;

import butterknife.ButterKnife;
import view.BaseView;

/**
 * Created by wcx on 2015/10/26.
 */
public abstract class BaseActivity extends BaseAppCompatActivity implements BaseView{
    protected Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isApplyKitKatTranslucency()) {
//            setSystemBarTintDrawable(getResources().getDrawable(R.drawable.sr_primary));
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mToolbar = ButterKnife.findById(this, R.id.toolbar);
        if (null!=mToolbar) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected RonaldoApplication getBaseApplication() {
        return (RonaldoApplication) getApplication();
    }

    @Override
    public void showError(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showException(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showNetError() {
        toggleNetworkError(true, null);
    }

    @Override
    public void showLoading(String msg) {
        toggleShowLoading(true, null);
    }

    @Override
    public void hideLoading() {
        toggleShowLoading(false, null);
    }
    protected abstract boolean isApplyKitKatTranslucency();
}
