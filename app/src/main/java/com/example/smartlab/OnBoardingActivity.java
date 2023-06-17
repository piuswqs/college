package com.example.smartlab;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {
    ViewPager pager;
   TextView textSkip;
   LinearLayout indicatorLayout;
    TextView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard1);

        pager = findViewById(R.id.page);
        OnBoardingAdapter adapter = new OnBoardingAdapter(this);
        pager.setAdapter(adapter);

        textSkip = findViewById(R.id.onb1TextSkip);
        indicatorLayout = findViewById(R.id.indicator_layout);
        
        setIndicator(0);

        textSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setIndicator(position);

                if (position==2){
                    textSkip.setText("Завершить");
                }
                else{
                    textSkip.setText("Пропустить");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void setIndicator(int position){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,0,10,0);
        dots = new TextView[3];
        indicatorLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setBackgroundResource(R.drawable.rounded_blue_circle);
            dots[i].setWidth(35);
            dots[i].setHeight(35);
            dots[i].setLayoutParams(params);
            indicatorLayout.addView(dots[i]);
        }
        dots[position].setBackgroundResource(R.drawable.round_full_blue_circle);
        dots[position].setWidth(35);
        dots[position].setHeight(35);
    }

    private int getItem(int i){
        return pager.getCurrentItem() + i;
    }

}
