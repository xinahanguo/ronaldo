package com.ronaldo.demo.holder;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wcx on 2015/10/30.
 */
public class AllPowerfulViewHolder {//万能的ViewHolder

    private View convertView;

    private SparseArray<View> arrays;//SparseArray是和HashMap类似，但是更高效。key只能是int值。

    public AllPowerfulViewHolder(Context mContext,ViewGroup parent,int layoutId){
        arrays=new SparseArray<>();
        convertView=LayoutInflater.from(mContext).inflate(layoutId, parent,false);
        convertView.setTag(this);
    }

    //得到AllPowerfulViewHolder
    public static AllPowerfulViewHolder get(Context mContext,View convertView,ViewGroup parent,int layoutId){
        if(convertView==null){
            return new AllPowerfulViewHolder(mContext,parent,layoutId);
        }
        return (AllPowerfulViewHolder) convertView.getTag();
    }


    //通过id来获取view。如果控件的id对应的view没有put到SparseArray，
    public <T extends View>T getView(int layoutId){
        View view = arrays.get(layoutId);
        if(null==view){
            view=convertView.findViewById(layoutId);
            arrays.put(layoutId,view);
        }
        return (T) view;
    }

    public View getConvertView(){
        return convertView;
    }
}
