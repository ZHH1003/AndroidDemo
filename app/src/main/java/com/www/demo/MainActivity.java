package com.www.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.www.demo.imageview.RotateImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RotateImageView rotateImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotateImageView = findViewById(R.id.imageView);

        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.pause).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.start) {
            rotateImageView.start();
        } else if (view.getId() == R.id.pause) {
            rotateImageView.start();
        } else if (view.getId() == R.id.stop) {
            rotateImageView.stop();
        }
    }
}
