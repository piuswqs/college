package com.example.smartlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smartlab.databinding.ActivityMainBinding;
import com.example.smartlab.ui.home.AnalyzFragment;
import com.example.smartlab.ui.notifications.SupportFragment;
import com.example.smartlab.ui.profile.ProfileFragment;
import com.example.smartlab.ui.result.ResultFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.white));

        menuView = findViewById(R.id.bot_menu);
        menuView.setOnNavigationItemSelectedListener(navListener);

        replaceFragment(new AnalyzFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_analyz:
                    replaceFragment(new AnalyzFragment());
                    break;
                case R.id.navigation_result:
                    replaceFragment(new ResultFragment());
                    break;
                case R.id.navigation_support:
                    replaceFragment(new SupportFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return false;
        }
    };

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameL, fragment);
        fragmentTransaction.commit();
    }
}
