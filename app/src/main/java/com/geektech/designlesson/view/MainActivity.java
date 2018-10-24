package com.geektech.designlesson.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.geektech.designlesson.R;
import com.geektech.designlesson.view.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    private Button mRightBtn;
    private Button mBottomBtn;
    private Button mTopBtn;
    private Button mLeftBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mRightBtn = findViewById(R.id.open_right_btn);
        mBottomBtn = findViewById(R.id.open_bottom_btn);
        mTopBtn = findViewById(R.id.open_top_btn);
        mLeftBtn = findViewById(R.id.open_left_btn);

        mRightBtn.setOnClickListener(this);
        mBottomBtn.setOnClickListener(this);
        mTopBtn.setOnClickListener(this);
        mLeftBtn.setOnClickListener(this);
    }

    /***
     * В любой из параметров overridePendingTransition()
     * можно передать 0 и тогда анимации перехода не будет
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.open_right_btn:
                ViewAnimationActivity.start(
                        this,
                        R.anim.slide_in_right,
                        R.anim.slide_out_right
                );
                break;

            case R.id.open_bottom_btn:
                ViewAnimationActivity.start(
                        this,
                        0,
                        0
                );
                break;

            case R.id.open_top_btn:
                //TODO: Add your custom transition
                showToast("Top screen not implemented");
                break;

            case R.id.open_left_btn:
                ViewPagerActivity.start(this);
                overridePendingTransition(
                        R.anim.slide_in_left,
                        R.anim.slide_out_left
                );
                break;
        }
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
