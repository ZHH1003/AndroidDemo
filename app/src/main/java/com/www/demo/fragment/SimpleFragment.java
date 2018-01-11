package com.www.demo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.www.demo.R;

/**
 * @author HH on 2018/1/10.
 */

public class SimpleFragment extends Fragment implements View.OnClickListener {

    private String title;
    private int color;
    private boolean showBanner;
    private boolean showTitle;
    private int statusHeight;
    private View statusView;
    private EditText colorEdt;
    private TextView titleTextView;
    private SeekBar seekBar;

    public static SimpleFragment getInstance(String title, int color, boolean showBanner, int statusHeight, boolean showTitle) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("color", color);
        bundle.putBoolean("showBanner", showBanner);
        bundle.putInt("statusHeight", statusHeight);
        bundle.putBoolean("showTitle", showTitle);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString("title");
            color = bundle.getInt("color");
            showBanner = bundle.getBoolean("showBanner");
            statusHeight = bundle.getInt("statusHeight");
            showTitle = bundle.getBoolean("showTitle");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_simple, container, false);

        statusView = rootView.findViewById(R.id.status_view);

        seekBar = rootView.findViewById(R.id.seekBar);
        titleTextView = rootView.findViewById(R.id.title_tv);
        ImageView banner = rootView.findViewById(R.id.banner_img);
        colorEdt = rootView.findViewById(R.id.color_edt);
        Button button = rootView.findViewById(R.id.color_btn);

        button.setOnClickListener(this);

        if (statusHeight > 0) {
            statusView.setBackgroundColor(color);
            statusView.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, statusHeight));
        }
        banner.setVisibility(showBanner ? View.VISIBLE : View.GONE);
        titleTextView.setVisibility(showTitle ? View.VISIBLE : View.GONE);

        titleTextView.setText(title);
        titleTextView.setBackgroundColor(color);


        if (showTitle && showBanner) {
            seekBar.setProgress(0);
            statusView.getBackground().setAlpha(0);
            titleTextView.getBackground().setAlpha(0);

        } else {
            seekBar.setProgress(seekBar.getMax());
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("debug", "onProgressChanged: " + progress);
                statusView.getBackground().setAlpha(progress);
                titleTextView.getBackground().setAlpha(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rootView;
    }


    @Override
    public void onClick(View view) {
        String s = colorEdt.getText().toString().trim();
        if (TextUtils.isEmpty(s) || s.length() < 6) {
            return;
        }
        int bgColor = Color.parseColor("#" + s);
        statusView.setBackgroundColor(bgColor);
        titleTextView.setBackgroundColor(bgColor);
    }
}
