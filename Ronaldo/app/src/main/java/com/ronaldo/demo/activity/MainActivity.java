package com.ronaldo.demo.activity;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.android.ronaldo.R;
/**
 * setNavigationIcon和setLogo设置Toolbar的icon
 */
public class MainActivity extends BaseActivity{

    private DrawerLayout mDrawerLayout;
    private ViewPager vpMain;
    private ListView leftMainList;
    private ActionBarDrawerToggle mActionBarDrawerToggle = null;
    private Toolbar mToolbar;

    @Override
    protected void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_main);
        vpMain = (ViewPager) findViewById(R.id.vp_main);
        leftMainList = (ListView) findViewById(R.id.home_left_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setTitle(getString(R.string.app_name));
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);//图像有返回的效果
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras() {

    }
}
