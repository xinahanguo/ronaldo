package com.ronaldo.wcx.ronaldo;

import android.os.Bundle;
import android.view.View;

import com.ronaldo.wcx.bean.Message;
import com.ypy.eventbus.EventBus;

/**
 * Created by wcx on 2015/10/26.
 */
public class NextActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        findViewById(R.id.btn_goto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Message("汶川县"));//发送消息
                finish();
            }
        });
    }
}
