package com.www.demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.www.demo.R;

/**
 * @author HH on 2018/1/10.
 */

public class SimpleFragment extends Fragment {

    private TextView titleTextView;

    private String title;
    private int color;
    private boolean showBanner;

    public static SimpleFragment getInstance(String title, int color, boolean showBanner) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("color", color);
        bundle.putBoolean("showBanner", showBanner);
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
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
        ImageView banner = rootView.findViewById(R.id.banner_img);
        banner.setVisibility(showBanner ? View.VISIBLE : View.GONE);

        titleTextView = rootView.findViewById(R.id.title_tv);
        titleTextView.setText(title);
        titleTextView.setBackgroundColor(color);
        return rootView;
    }




}
