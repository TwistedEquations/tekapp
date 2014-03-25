package com.teksyndicate.app.webservice;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Patrick on 25/03/2014.
 */
public class TekImageCache implements ImageLoader.ImageCache {

    private LruCache<String, Bitmap> imageCache;

    public TekImageCache(LruCache<String, Bitmap> imageCache) {
        this.imageCache = imageCache;
    }

    @Override
    public Bitmap getBitmap(String url) {
        return imageCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        imageCache.put(url,bitmap);
    }
}
