package com.teksyndicate.app.webservice;

import java.util.Locale;

/**
 * Created by Patrick on 27/03/2014.
 */
public class RequestConstants {

    public static final String URL_BASE = "https://teksyndicate.com/json/v1/";

    public static final String URL_TAG = URL_BASE+"tag/";

    public static String getUrlForTag(String tag) {
        tag = tag.toLowerCase(Locale.ENGLISH);
        tag.replaceAll(" ","-");
        return URL_TAG+tag;
    }
}
