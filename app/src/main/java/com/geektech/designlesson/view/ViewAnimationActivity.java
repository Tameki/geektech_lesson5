package com.geektech.designlesson.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.geektech.designlesson.R;

public class ViewAnimationActivity extends AppCompatActivity {

    public static void start(Activity activity, int startId, int exitId){
        activity.startActivity(new Intent(activity, ViewAnimationActivity.class));

        activity.overridePendingTransition(
                startId,
                exitId
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(
                R.anim.slide_in_left,
                R.anim.slide_out_left
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        Animation anim = AnimationUtils.loadAnimation(
                        this,
                        R.anim.alpha
                );

        findViewById(R.id.card_view).startAnimation(anim);
    }
}
