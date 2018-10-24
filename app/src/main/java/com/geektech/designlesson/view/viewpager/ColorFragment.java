package com.geektech.designlesson.view.viewpager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.designlesson.R;

// Created by askar on 10/24/18.
public class ColorFragment extends Fragment {
    public static String COLOR_KEY = "color";

    public static ColorFragment newInstance(int color) {
        Bundle args = new Bundle();
        args.putInt(COLOR_KEY, color);
        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static int getColor(Bundle args){
        return args.getInt(COLOR_KEY, Color.BLACK);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_color, container, false);

        init(rootView);

        return rootView;
    }

    private void init(View rootView){
        if (getArguments() != null) {
            rootView.findViewById(R.id.fragment_color_view)
                    .setBackgroundColor(getColor(getArguments()));
        }
    }
}
