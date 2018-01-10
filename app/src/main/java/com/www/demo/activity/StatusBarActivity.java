package com.www.demo.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.www.demo.R;

/**
 * @author HH on 2018/1/9.
 */

public class StatusBarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_status_bar);


        int code = Build.VERSION.SDK_INT;
        if (code >= Build.VERSION_CODES.KITKAT && code < Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            ViewGroup decorView = (ViewGroup) findViewById(android.R.id.content);

            View statusView = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
            statusView.setLayoutParams(params);
            statusView.setBackgroundColor(Color.parseColor("#68b96d"));

            decorView.getChildAt(0).setFitsSystemWindows(true);
            decorView.addView(statusView, 0);


        }
    }
}
