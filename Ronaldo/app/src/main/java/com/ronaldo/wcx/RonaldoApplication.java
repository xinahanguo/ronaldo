package com.ronaldo.wcx;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.ronaldo.wcx.cache.LruBitmapCache;

/**
 * Created by wcx on 2015/10/27.
 */
public class RonaldoApplication extends Application{
    public static final String TAG = "VolleyPatterns";
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static RonaldoApplication sInstance;

    //主线程的Handler，主线程，主线程ID，主线程的looper
    private static Handler mMainThreadHandler = null;
    private static Thread mMainThread = null;
    private static int  mMainThreadId;
    private static Looper mMainThreadLooper = null;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        this.mMainThreadHandler = new Handler();
        this.mMainThread = Thread.currentThread();
        this.mMainThreadId = android.os.Process.myTid();
        this.mMainThreadLooper = getMainLooper();
    }

    //对外暴露方法
    public static Handler getMainThreadHandler(){
        return mMainThreadHandler;
    }
    public static Thread getMainThread(){
        return mMainThread;
    }
    public static int  getMainThreadId(){
        return mMainThreadId;
    }
    public static synchronized RonaldoApplication getInstance() {
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,new LruBitmapCache(this));
        }
        return this.mImageLoader;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        VolleyLog.d("Adding request to queue: %s", req.getUrl());
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
