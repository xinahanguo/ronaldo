package com.ronaldo.wcx.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by River on 7/7/15.
 * 项目中并没有太多需要缓存的图片，所以使用简易版的缓存则可
 */
public class LruBitmapCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    public LruBitmapCache(int maxSize) {
        super(maxSize);
    }

    public LruBitmapCache(Context ctx) {
        this(getCacheSize(ctx));
    }

    /**
     * LRU需要时常判断加起来的图片缓存是否超过指定的内存
     *      需要复写sizeOf，把图片大小返回，这样就可以判断了。超过的话就会回收。
     * */
    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    /**取出value*/
    @Override
    public Bitmap getBitmap(String url) {

        return null;
    }

    /**
     * put图片资源
     */
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }

    // Returns a cache size equal to approximately three screens worth of images.
    public static int getCacheSize(Context ctx) {
        final DisplayMetrics displayMetrics = ctx.getResources().
                getDisplayMetrics();
        final int screenWidth = displayMetrics.widthPixels;
        final int screenHeight = displayMetrics.heightPixels;
        // 4 bytes per pixel
        final int screenBytes=screenWidth*screenHeight*4;
        return screenBytes*3;
        /**
         *  dalvik虚拟机的内存，一般是八分之一来缓存图片
         *      Runtime.getRuntime().maxMemory()/8;
         */
    }
}