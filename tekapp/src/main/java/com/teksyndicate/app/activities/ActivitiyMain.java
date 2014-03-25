package com.teksyndicate.app.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.teksyndicate.app.R;
import com.teksyndicate.app.adapters.ListenerMainTabs;
import com.teksyndicate.app.webservice.TekVolley;


public class ActivitiyMain extends ActivityMenu {

    private ActionBar actionBar;
    private String[] tabs = {"All", "Videos", "Articles", "Reviews", "NEWS FEED"};
    private ViewPager viewPager;
    private ListenerMainTabs listenerMainTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        listenerMainTabs = new ListenerMainTabs(viewPager);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        addTabs();

    }

    private void addTabs() {

        for(String tabText : tabs) {
            ActionBar.Tab tab = actionBar.newTab();
            tab.setText(tabText);
            tab.setTabListener(listenerMainTabs);
            actionBar.addTab(tab);
        }

    }




}
