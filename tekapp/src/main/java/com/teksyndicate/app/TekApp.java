package com.teksyndicate.app;

import android.app.ActivityManager;
import android.app.Application;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.teksyndicate.app.webservice.TekImageCache;

/**
 * Created by Patrick on 25/03/2014.
 */
public class TekApp extends Application {

    private RequestQueue queue;
    private ImageLoader imageLoader;
    private int loaderCacheSize;
    private LruCache<String, Bitmap> lruImageCache;

    @Override
    public void onCreate() {

        queue = Volley.newRequestQueue(this);
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        int memoryClass = am.getMemoryClass();
        loaderCacheSize = memoryClass/8;

        lruImageCache = new LruCache<String, Bitmap>(loaderCacheSize);
        imageLoader = new ImageLoader(queue, new TekImageCache(lruImageCache));

        super.onCreate();
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public RequestQueue getRequestQueue() {
        return queue;
    }
}
