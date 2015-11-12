package com.ronaldo.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public abstract class CommonAdapter<T> extends BaseAdapter{
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;

    public CommonAdapter(Context context, List<T> mDatas){
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
