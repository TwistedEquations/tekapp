package com.teksyndicate.app.models;

import com.google.gson.Gson;

/**
 * Created by Patrick on 25/03/2014.
 */
public class Model {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
