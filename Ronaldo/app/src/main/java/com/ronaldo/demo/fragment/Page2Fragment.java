package com.ronaldo.demo.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.android.ronaldo.R;

/**
 * Created by wcx on 2015/11/10.
 */
public class Page2Fragment extends BaseFragment{
    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_page2;
    }

    @Override
    protected void initView() {
        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.fragment_page2, null);
        Button btn = (Button) inflate.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("wcx","onClick");
            }
        });

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("wcx","onTouch"+event.getAction());
                return false;
            }
        });
    }
}
