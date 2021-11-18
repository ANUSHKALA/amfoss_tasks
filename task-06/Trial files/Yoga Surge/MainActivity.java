package com.example.yogasurge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;


    private SliderAdapter sliderAdapter;

    private Button mNextBtn;
    private Button mBackBtn;


    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);


        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);
    }
    public void addDotsIndicator(int position){

        mDots = new TextView[5];
        mDotLayout.removeAllViews();

        for(int i = 0; i<mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(36);
            mDots[i].setTextColor(getResources().getColor(R.color.black));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.white));

        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            mCurrentPage = i;

            if (i == 0) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("");}

            else if (i == mDots.length-1 ) {

                    mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(true);
                    mBackBtn.setVisibility(View.INVISIBLE);

                    mNextBtn.setText("FINISH");
                    mBackBtn.setText("BACK");
                }

            else{

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("SKIP");
                mBackBtn.setText("BACK");

            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
