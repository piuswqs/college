package com.example.smartlab;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
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
    ArrayList<OnBoardingItem> items = new ArrayList<OnBoardingItem>();

   TextView textSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard1);

        ViewPager pager = findViewById(R.id.page);
        OnBoardingAdapter adapter = new OnBoardingAdapter(this);
        pager.setAdapter(adapter);

        textSkip = findViewById(R.id.onb1TextSkip);


    }
}
