package com.geektech.designlesson.view.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geektech.designlesson.R;

// Created by askar on 10/24/18.
public class ViewPagerActivity extends AppCompatActivity {

    private AnimatedViewPager mViewPager;
    private ImagesPagerAdapter mAdapter;

    //region Static

    public static void start(Activity activity){
        activity.startActivity(new Intent(activity, ViewPagerActivity.class));
    }

    //endregion

    //На нажатие, переписываем переход на наш
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_right
        );
    }


    //region Lifecycle

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        init();
    }

    //endregion

    private void init(){
        mAdapter = new ImagesPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.custom_view_pager);
        mViewPager.setAdapter(mAdapter);
    }

}
