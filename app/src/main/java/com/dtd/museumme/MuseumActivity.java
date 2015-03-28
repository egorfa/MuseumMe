package com.dtd.museumme;


import android.os.Bundle;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.Arrays;
import java.util.List;


public class MuseumActivity extends SherlockFragmentActivity {

    public SlidingMenu menu;
    public List<String> MenuItemTitles;
    ListView MenuList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);

        MenuItemTitles = Arrays.asList(getResources().getStringArray(R.array.MenuList));

        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeDegree(0.9f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.sidemenu);
        menu.setBehindWidthRes(R.dimen.slidingmenu_behind_width);

        MenuList = (ListView) findViewById(R.id.MenuList);
        MenuListAdapter adapter = new MenuListAdapter(this, R.layout.menu_list_item, MenuItemTitles);
        MenuList.setAdapter(adapter);

        // i'm a test commit
    }

}
