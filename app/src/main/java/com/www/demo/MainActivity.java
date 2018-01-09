package com.www.demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.www.demo.activity.HaveFragmentActivity;
import com.www.demo.activity.HeaderBannerActivity;
import com.www.demo.activity.SplashActivity;
import com.www.demo.activity.StatusBarActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.button:
                startActivity(new Intent(this, SplashActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, HeaderBannerActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, StatusBarActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, HaveFragmentActivity.class));

                break;

            default:
                break;
        }

    }
}
