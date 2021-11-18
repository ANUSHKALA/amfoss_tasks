package com.example.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    private Slider slider;
    private Object Slider;

    public MainActivity(Object slider) {
        Slider = slider;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        LinearLayout mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        slider = new Slider(this);
        mSlideViewPager.setAdapter(slider);
    }
}
