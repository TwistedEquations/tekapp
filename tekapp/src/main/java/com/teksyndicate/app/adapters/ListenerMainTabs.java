package com.teksyndicate.app.adapters;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

/**
 * Created by Patrick on 25/03/2014.
 */
public class ListenerMainTabs implements ActionBar.TabListener {

    public ViewPager pager;

    public ListenerMainTabs(ViewPager pager){
        this.pager = pager;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int tabPosition = tab.getPosition();
        pager.setCurrentItem(tabPosition);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
