package com.example.my_first_application;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    LinearLayout dotsLayout;
    SliderAdapter adapter;
    ViewPager2 pager2;
    int list[];
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsLayout = findViewById(R.id.dots_container);
        pager2 = findViewById(R.id.view_pager2);

        list = new int[4];
        list[0] = getResources().getColor(R.color.cyan);
        list[1] = getResources().getColor(R.color.red);
        list[2] = getResources().getColor(R.color.blue);
        list[3] = getResources().getColor(R.color.green);
        //list[4] = getResources().getColor(R.color.red);


        adapter = new SliderAdapter(list);
        pager2.setAdapter(adapter);

        dots = new TextView[4];

        dotsIndicator();

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                selectedIndicator(position);
                super.onPageSelected(position);
            }
        });




    }

    private void selectedIndicator(int position) {
        for (int i=0;i<dots.length;i++)
        {
           if (i==position)
           {
               dots[i].setTextColor(list[position]);
           }
           else
           {
               dots[i].setTextColor(getResources().getColor(R.color.grey));
           }
        }
    }

    private void dotsIndicator() {
        for (int i=0; i<dots.length; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            dotsLayout.addView(dots[i]);
        }
    }
}
