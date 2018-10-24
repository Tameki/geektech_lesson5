package com.geektech.designlesson.view.viewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Created by askar on 10/24/18.
// Только для примера)
public class ImagesPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Integer> mColors = new ArrayList<>(
            Arrays.asList(
                    Color.GREEN,
                    Color.RED,
                    Color.YELLOW,
                    Color.BLUE,
                    Color.DKGRAY
            )
    );

    public ImagesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setColors(List<Integer> colors){
        mColors.clear();
        mColors.addAll(colors);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {
        return ColorFragment.newInstance(mColors.get(i));
    }

    @Override
    public int getCount() {
        return mColors.size();
    }
}
