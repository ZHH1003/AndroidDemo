package com.www.demo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.www.demo.R;

/**
 * @author HH on 2018/1/9.
 */

public class HaveFragmentActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_have_fragment);

        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBarBackgroundColor(R.color.colorPrimary);
        bottomNavigationBar.setPadding(0, 0, 0, 0);


        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("5")
                .setBackgroundColor(R.color.colorAccent)
                .setBorderWidth(0);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_me, "聊天"))
                .addItem(new BottomNavigationItem(R.drawable.icon_me, "通讯录").setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.icon_me, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.icon_me, "发现"))
                .setFirstSelectedPosition(2)
                .initialise();


    }

    @Override
    public void onTabSelected(int position) {

        Log.d("debug", "onTabSelected: " + position);

    }

    @Override
    public void onTabUnselected(int position) {
        Log.d("debug", "onTabUnselected: " + position);
    }

    @Override
    public void onTabReselected(int position) {
        Log.d("debug", "onTabReselected: " + position);

    }
}
