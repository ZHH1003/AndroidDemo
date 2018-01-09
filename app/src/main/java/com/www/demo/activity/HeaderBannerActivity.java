package com.www.demo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.www.demo.R;

/**
 * @author HH on 2018/1/8.
 */

public class HeaderBannerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headerbanner);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(ViewGroup.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            //设置状态栏透明
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup contentView = window.getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
            //true: 为SystemBar预留空间   false: 不为SystemBar预留空间
            contentView.getChildAt(0).setFitsSystemWindows(false);
        }


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            //android6.0以上可以设置状态栏文字颜色
            //设置白底黑色字体
            getWindow().getDecorView().setSystemUiVisibility(ViewGroup.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}
