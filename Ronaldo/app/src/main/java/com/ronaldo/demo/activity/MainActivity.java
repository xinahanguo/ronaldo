package com.ronaldo.demo.activity;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.ronaldo.R;
import com.ronaldo.demo.adapter.CommonFragmentAdapter;
import com.ronaldo.demo.adapter.LeftListAdapter;
import com.ronaldo.demo.domain.LeftListEntity;
import com.ronaldo.demo.fragment.BaseFragment;
import com.ronaldo.demo.presenter.HomePresenter;
import com.ronaldo.demo.view.HomeView;
import java.util.List;
/**
 * setNavigationIcon和setLogo设置Toolbar的icon
 */
public class MainActivity extends BaseActivity implements HomeView{

    private DrawerLayout mDrawerLayout;
    private ViewPager vpMain;
    private ListView leftMainList;
    private ActionBarDrawerToggle mActionBarDrawerToggle = null;
    private Toolbar mToolbar;
    private int currentLeftPosition;
    private LeftListAdapter adapter;

    @Override
    protected void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_main);
        vpMain = (ViewPager) findViewById(R.id.vp_main);
        leftMainList = (ListView) findViewById(R.id.home_left_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        HomePresenter homePresenter = new HomePresenter(this,this);
        homePresenter.init();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras() {

    }

    @Override
    public void initializeViews(List<BaseFragment> fragments, List<LeftListEntity> listData) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setTitle(getString(R.string.app_name_cn));
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if(adapter!=null){
                    setTitle(((LeftListEntity) adapter.getItem(adapter.getCurrentPosition())).getName());
                }
            }
        };
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);//图像有返回的效果
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        if (null != fragments && !fragments.isEmpty()) {
            /**
             * ViewPager会预先加载下一页数据，如果在从第一个页面滑到第二个页面，那么第第三个页面被创建，而在滑动第一个页面后，第三个页面又会销毁。
             * 这样如果第三个页面有网络加载的话，就会显得卡顿。设置setOffscreenPageLimit，可以缓存被销毁的页面。默认为1
             */
            vpMain.setOffscreenPageLimit(fragments.size());
            vpMain.setAdapter(new CommonFragmentAdapter(getSupportFragmentManager(),fragments));
        }
        adapter = new LeftListAdapter(this, listData);
        adapter.setCurrentPosition(0);
        leftMainList.setAdapter(adapter);
        setTitle(((LeftListEntity) adapter.getItem(adapter.getCurrentPosition())).getName());
        leftMainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentLeftPosition=position;
                adapter.setCurrentPosition(currentLeftPosition);
                adapter.notifyDataSetChanged();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                vpMain.setCurrentItem(adapter.getCurrentPosition(),false);
            }
        });
    }
}
