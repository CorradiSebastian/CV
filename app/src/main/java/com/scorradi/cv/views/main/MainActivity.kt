package com.scorradi.cv.views.main

import android.app.Activity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.scorradi.cv.R

class MainActivity : Activity() {

    @BindView(R.id.viewPager)
    private lateinit var ViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this);

    }
}