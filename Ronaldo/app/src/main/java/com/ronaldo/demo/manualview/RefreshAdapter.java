package com.ronaldo.demo.manualview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.ronaldo.R;

import java.util.ArrayList;

/**
 * Created by ghost on 15/6/26.
 */
public abstract class RefreshAdapter<T> extends RecyclerView.Adapter {
    public ArrayList<T> data;
    private static final int TYPE_FOOTER=100;
    private View footView;
    public Context context;
    private boolean hasFoot = true;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        if (i == TYPE_FOOTER) {
            footView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.load_more_footer, null);
            footView.setVisibility(View.GONE);
            FooterViewHolder foot = new FooterViewHolder(footView);
            return foot;
        }
        return onCreateItem(viewGroup,i);
    }

    public void addAll(ArrayList data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public abstract RecyclerView.ViewHolder onCreateItem(ViewGroup parent, int viewType);
    public abstract void onBindItem(RecyclerView.ViewHolder holder, int position);

    public RefreshAdapter(ArrayList<T> data) {
        if(data==null){
            this.data = new ArrayList<>();
        }
        this.data = data;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof FooterViewHolder){
            holder.itemView.setTag("foot");
            return;
        }
        onBindItem(holder,position);
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (position+1 >= getItemCount()) {
            return TYPE_FOOTER;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if(hasFoot) {
            return data.size() + 1;
        }else {
            return data.size();
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
