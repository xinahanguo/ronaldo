package com.ronaldo.demo.manualview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ronaldo.R;
public class RefreshRecyclerView extends LinearLayout {
    private View v;
    private SwipeRefreshLayout srl;
    private RecyclerView rv;

    private int lastVisibleItem;
    private LinearLayoutManager manager;
    private View footView;
    private RefreshAdapter adapter;
    private boolean isLastPage;

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public RefreshRecyclerView(Context context) {
        super(context);
        initView();
    }


    public RefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RefreshRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        v = LayoutInflater.from(getContext()).inflate(R.layout.refresh_recyclerview, null);
        srl = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefreshLayout);
        srl.setColorSchemeResources(R.color.text_color_yellow,R.color.text_color_yellow, R.color.text_color_yellow,R.color.text_color_yellow);
        rv = (RecyclerView) v.findViewById(R.id.RecyclerView);
        manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        addView(v);
    }

    public void setAdapter(RefreshAdapter adapter) {
        this.adapter = adapter;
        rv.setAdapter(adapter);
    }

    public void setOnRefreshListener(final OnRefreshListener RefreshListener) {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefreshListener.setOnRefreshListener();
            }
        });
    }

    public interface onPullListener {
         void setOnPullListener();
    }

    public void setOnPullListener(final RefreshRecyclerView.onPullListener PullListener) {
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (isLastPage()) {
                    return;
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    if (footView == null) {
                        footView = rv.findViewWithTag("foot");
                    }
                    TextView tv = (TextView) footView.findViewById(R.id.no_more_textView);
                    ProgressBar bar = (ProgressBar) footView.findViewById(R.id.load_more_progressBar);
                    bar.setVisibility(VISIBLE);
                    tv.setText("正在加载...");
                    footView.setVisibility(View.VISIBLE);
                    PullListener.setOnPullListener();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = manager.findLastVisibleItemPosition();
            }
        });
    }

    public interface OnRefreshListener {
         void setOnRefreshListener();
    }

    public void setLoadFinsh() {
        if (footView != null) {
            if (isLastPage()) {
                TextView tv = (TextView) footView.findViewById(R.id.no_more_textView);
                ProgressBar bar = (ProgressBar) footView.findViewById(R.id.load_more_progressBar);
                bar.setVisibility(GONE);
                tv.setText("没有更多");
                footView.setVisibility(VISIBLE);
            } else {
                footView.setVisibility(GONE);
            }
        }
        srl.setRefreshing(false);
    }
}
