package com.geektech.designlesson.view.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

// Created by askar on 10/24/18.
public class AnimatedViewPager extends ViewPager implements ViewPager.PageTransformer {
    private static int DEFAULT_MARGIN = 40;
    private float MAX_SCALE = 0.0f;
    private int mPageMargin;
    private boolean mAnimationEnabled = true;
    private boolean mFadeEnabled = false;
    private float mFadeFactor = 0.5f;

    //region Constructor

    public AnimatedViewPager(Context context) {
        this(context, null);
    }

    public AnimatedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //endregion

    //region Private

    private void init(Context context){
        // clipping should be off on the pager for its children so that they can scale out of bounds.
        setClipChildren(false);
        setClipToPadding(false);
        // to avoid fade effect at the end of the page
        setOverScrollMode(2);
        setPageTransformer(false, this);
        setOffscreenPageLimit(3);
        mPageMargin = dp2px(context.getResources(), DEFAULT_MARGIN);
        setPadding(mPageMargin, mPageMargin, mPageMargin, mPageMargin);
    }

    public int dp2px(Resources resource, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resource.getDisplayMetrics());
    }

    //endregion

    //region Setters

    public void setAnimationEnabled(boolean enable) {
        this.mAnimationEnabled = enable;
    }

    public void setFadeEnabled(boolean mFadeEnabled) {
        this.mFadeEnabled = mFadeEnabled;
    }

    public void setFadeFactor(float fadeFactor) {
        this.mFadeFactor = fadeFactor;
    }

    //endregion

    @Override
    public void setPageMargin(int marginPixels) {
        mPageMargin = marginPixels;
        setPadding(mPageMargin, mPageMargin, mPageMargin, mPageMargin);
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        if (mPageMargin <= 0|| !mAnimationEnabled)
            return;

        page.setPadding(mPageMargin / 3, mPageMargin / 3, mPageMargin / 3, mPageMargin / 3);

        if (MAX_SCALE == 0.0f && position > 0.0f && position < 1.0f) {
            MAX_SCALE = position;
        }

        position = position - MAX_SCALE;
        float absolutePosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f) {
            if(mFadeEnabled)
                page.setAlpha(mFadeFactor);
        } else if (position == 0.0f) {
            page.setScaleX((1 + MAX_SCALE));
            page.setScaleY((1 + MAX_SCALE));
            page.setAlpha(1);
        } else {
            page.setScaleX(1 + MAX_SCALE * (1 - absolutePosition));
            page.setScaleY(1 + MAX_SCALE * (1 - absolutePosition));
            if(mFadeEnabled)
                page.setAlpha( Math.max(mFadeFactor, 1 - absolutePosition));
        }
    }
}