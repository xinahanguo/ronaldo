package com.ronaldo.demo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by wcx on 2015/11/2.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity{

    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        Bundle bundle = getIntent().getExtras();
        if(null!=bundle){
            getBundleExtras();
        }
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        initView();
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    protected abstract void initView();

    protected abstract int getContentViewLayoutID();

    protected abstract void getBundleExtras();
}
