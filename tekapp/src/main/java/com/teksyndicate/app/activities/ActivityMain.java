package com.teksyndicate.app.activities;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.os.Bundle;

import com.teksyndicate.app.R;
import com.teksyndicate.app.adapters.AdapterMainPager;
import com.teksyndicate.app.adapters.ListenerMainTabs;
import com.teksyndicate.app.fragments.FragmentTagList;

import java.util.ArrayList;
import java.util.List;


public class ActivityMain extends ActivityMenu {

    private ActionBar actionBar;
    private String[] tabs = {"All", "Videos", "Articles", "Reviews", "NEWS FEED"};
    private ViewPager viewPager;
    private ListenerMainTabs listenerMainTabs;
    List<Fragment> fragments = new ArrayList<Fragment>();
    AdapterMainPager adapterMainPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        listenerMainTabs = new ListenerMainTabs(viewPager);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        addTabs();

        fragments.add(new FragmentTagList());
        adapterMainPager = new AdapterMainPager(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapterMainPager);
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
