package com.ronaldo.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ronaldo.R;
import com.ronaldo.demo.domain.LeftListEntity;
import com.ronaldo.demo.holder.ViewHolder;

import java.util.List;

/**
 * Created by wcx on 2015/11/12.
 */
public class LeftListAdapter extends CommonAdapter<LeftListEntity>{

    private int currentPosition;
    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public LeftListAdapter(Context context, List<LeftListEntity> mDatas) {
        super(context, mDatas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.get(mContext, convertView, parent, R.layout.item_leftdata);
        ImageView leftIcon =viewHolder.getView(R.id.left_icon);
        TextView leftText = viewHolder.getView(R.id.left_text);
        leftIcon.setBackgroundResource(mDatas.get(position).getIconResId());
        if(currentPosition==position){
            leftText.setTextColor(mContext.getResources().getColor(R.color.left_select));
        }else{
            leftText.setTextColor(mContext.getResources().getColor(android.R.color.black));
        }
        leftText.setText(mDatas.get(position).getName());
        return viewHolder.getConvertView();
    }
}
