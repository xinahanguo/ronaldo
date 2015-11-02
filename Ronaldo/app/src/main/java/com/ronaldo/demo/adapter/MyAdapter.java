package com.ronaldo.demo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.android.ronaldo.R;
import com.ronaldo.demo.holder.AllPowerfulViewHolder;

import java.util.List;

/**
 * Created by wcx on 2015/10/30.
 */
public class MyAdapter extends CommonAdapter<String> {

    public MyAdapter(Context context, List<String> mDatas, int layoutId) {
        super(context, mDatas, layoutId);
    }

    @Override
    protected void callBack(AllPowerfulViewHolder holder, String item) {
        TextView view = holder.getView(R.id.id_tv_title);
        view.setText(item);
    }
}
