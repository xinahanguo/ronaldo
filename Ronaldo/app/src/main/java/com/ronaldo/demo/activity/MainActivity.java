package com.ronaldo.demo.activity;

import android.widget.ListView;

import com.android.ronaldo.R;
import com.ronaldo.demo.adapter.MyAdapter;
import com.ronaldo.demo.bean.NavigationEntity;
import com.ronaldo.demo.fragment.BaseFragment;
import com.ronaldo.demo.present.MainPresent;
import com.ronaldo.demo.view.MainView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * setNavigationIcon和setLogo设置Toolbar的icon
 */
public class MainActivity extends BaseActivity implements MainView{

    private ListView mListView;
    private List<String> mDatas =new ArrayList<String>(Arrays.asList("Hello", "World", "Welcome"));
    private MyAdapter mAdapter;

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.home_navigation_list);
        mListView.setAdapter(mAdapter = new MyAdapter(this, mDatas,R.layout.item_text));
        MainPresent mainPresent = new MainPresent(mContext, this);
        mainPresent.initialized();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras() {
    }

    @Override
    public void initializeViews(List<BaseFragment> fragments, List<NavigationEntity> navigationList) {

    }
}
