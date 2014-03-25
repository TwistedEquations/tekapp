package com.teksyndicate.app.webservice;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.teksyndicate.app.TekApp;

/**
 * Created by Patrick on 25/03/2014.
 */
public class TekVolley {

    public static ImageLoader getImageLoader(Context context) {
        TekApp tekApp = (TekApp) context.getApplicationContext();
        return tekApp.getImageLoader();
    }

    public static RequestQueue getRequestQueue(Context context) {
        TekApp tekApp = (TekApp) context.getApplicationContext();
        return tekApp.getRequestQueue();
    }
}
