package com.ronaldo.wcx.ronaldo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ronaldo.wcx.bean.Message;
import com.ypy.eventbus.EventBus;

/**
 * setNavigationIcon和setLogo设置Toolbar的icon
 */
public class MainActivity extends BaseActivity {

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EventBus.getDefault().register(this);//注册EventBus
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("罗纳尔多");
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_capture:
                        break;
                }
                return true;
            }
        });

        tvContent = (TextView) findViewById(R.id.tv_content);
        Button btnGoto = (Button) findViewById(R.id.btn_goto);
        btnGoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }

    //接收EventBus发出的消息
    public void onEventMainThread(Message event) {
        String msg = "onEventMainThread收到了消息：" + event.getMessage();
        tvContent.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//注销EventBus
    }
}
