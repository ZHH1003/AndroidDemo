package com.www.demo.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.www.demo.R;
import com.www.demo.fragment.SimpleFragment;

/**
 * @author HH on 2018/1/9.
 */

public class HaveFragmentActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;
    private TextBadgeItem badgeItem;
    private SimpleFragment shopFragment;
    private SimpleFragment groupFragment;
    private SimpleFragment exploreFragment;
    private SimpleFragment meFragment;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;

    private int shopColor = Color.parseColor("#904304");
    private int groupColor = Color.parseColor("#906505");
    private int exploreColor = Color.parseColor("#509606");
    private int meColor = Color.parseColor("#190590");

    private int statusHeight;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_fragment);
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            statusHeight = getStatusHeight();
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        fragmentManager = getSupportFragmentManager();
        //角标提醒
        badgeItem = new TextBadgeItem();
        //选中时是否隐藏
        badgeItem.setHideOnSelect(false)
                //文字
                .setText("9")
                //背景颜色
                .setBackgroundColor(R.color.color_badgeItem)
                .setTextColor(R.color.colorPrimary);

        //设置tab点击监听
        bottomNavigationBar.setTabSelectedListener(this);
        //设置Mode
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);//MODE_FIXED, MODE_SHIFTING
        //设置BackgroundStyle
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        //设置背景颜色
        bottomNavigationBar.setBarBackgroundColor(R.color.bottomNavigationBarBackground);
        //设置被选中item颜色, item也可以单独设置
        bottomNavigationBar.setActiveColor(R.color.color_icon_tab_selected);
        //设置Item
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_tab_shopping, "购物"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_tab_group, "通讯录"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_tab_explore, "发现"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_tab_me, "我").setBadgeItem(badgeItem));
        //初始选中项
        bottomNavigationBar.setFirstSelectedPosition(1);
        //初始化
        bottomNavigationBar.initialise();
        //选中指定tab
        bottomNavigationBar.selectTab(1);

        getStatusHeight();

    }

    @Override
    public void onTabSelected(int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //设置状态栏白色字体
            getWindow().getDecorView().setSystemUiVisibility(ViewGroup.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        switch (position) {
            case 0:
                if (shopFragment == null) {
                    shopFragment = SimpleFragment.getInstance("购物", shopColor, false, statusHeight);
                    transaction.add(R.id.container, shopFragment);
                } else {
                    transaction.show(shopFragment);
                }
                currentFragment = shopFragment;
                break;
            case 1:
                if (groupFragment == null) {
                    groupFragment = SimpleFragment.getInstance("通讯录", groupColor, false, statusHeight);
                    transaction.add(R.id.container, groupFragment);
                } else {
                    transaction.show(groupFragment);
                }
                currentFragment = groupFragment;
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //设置白底黑字
                    getWindow().getDecorView().setSystemUiVisibility(ViewGroup.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }

                if (exploreFragment == null) {
                    exploreFragment = SimpleFragment.getInstance("发现", exploreColor, true, 0);
                    transaction.add(R.id.container, exploreFragment);
                } else {
                    transaction.show(exploreFragment);
                }
                currentFragment = exploreFragment;
                break;
            case 3:
                if (meFragment == null) {
                    meFragment = SimpleFragment.getInstance("我", meColor, false, statusHeight);
                    transaction.add(R.id.container, meFragment);
                } else {
                    transaction.show(meFragment);
                }

                currentFragment = meFragment;
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    public int getStatusHeight() {
        int pixelSize = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            pixelSize = getResources().getDimensionPixelSize(resourceId);
            pixelSize += getResources().getDimensionPixelSize(R.dimen.navigation_height);

        }
        return pixelSize;
    }
}
