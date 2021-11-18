package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Slider extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflate;

    public Slider(Context context){

        this.context = context;

    }
    //arrays
    public int[] slide_images = {

            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img_three,
            R.drawable.img4,
            R.drawable.img5
    };

    public String[] slide_headings = {

            "YOGA SURGE",
            "Healthy Freaks Exercise",
            "Cycling",
            "Meditation",
            "Anushka Kaimal"

    };

    public String[] slide_descs = {

            "Welcome to the Yoga World" +
                    "Inhale the future, exhale the past",
            "Letting go is the hardest asana",
            "You cannot always control what goes outside. But you can always control what goes inside.",
            "The longest journey of any person is the journey inward.",
            "I like stargazing and studying about the celestial bodies " +
                    "The fact that every atom except hydrogen and helium was once part of a star is just amazing."

    };




    @Override
    public int getCount() {

        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    public Object instantiateItem(ViewGroup container, int position){

        Object layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = ((LayoutInflater) layoutInflater).inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;


    }

    public void destroy(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);
    }
}
