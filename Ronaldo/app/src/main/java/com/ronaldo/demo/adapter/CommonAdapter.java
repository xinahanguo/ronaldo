package com.ronaldo.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ronaldo.demo.holder.AllPowerfulViewHolder;

import java.util.List;


/**
 * Created by wcx on 2015/10/30.
 */
public abstract  class CommonAdapter<T> extends BaseAdapter{
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected int layoutId;

    public CommonAdapter(Context context, List<T> mDatas,int layoutId){
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.layoutId=layoutId;
    }

    @Override
    public int getCount(){
        return mDatas.size();
    }

    @Override
    public T getItem(int position){
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AllPowerfulViewHolder holder = AllPowerfulViewHolder.get(mContext, convertView, parent, layoutId);
        callBack(holder,getItem(position));
        return holder.getConvertView();
    }

    protected abstract void callBack(AllPowerfulViewHolder holder, T item);

}
