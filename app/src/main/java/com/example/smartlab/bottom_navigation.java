package com.example.smartlab;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.databinding.ActivityBottomNavigationBinding;

import java.util.ArrayList;

public class bottom_navigation extends AppCompatActivity {
    ArrayList<Services> services = new ArrayList<Services>();

    private ActivityBottomNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_analyz, R.id.navigation_result, R.id.navigation_support, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_bottom_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        setData();

        RecyclerView listView = findViewById(R.id.lv);
        ServicesAdapter servicesAdapter = new ServicesAdapter(this, services);
        listView.setAdapter(servicesAdapter);

    }
    void setData(){
        services.add(new Services("ПЦР-тест на определение РНК коронавируса стандратный", "2 дня","1800 ₽"));
        services.add(new Services("Клинический анализ крови с лейкоцитарной формулировкой","1 день","690 ₽"));
        services.add(new Services("Биохимический анализ крови, базовый", "1 день", "2440 ₽"));
        services.add(new Services("СОЭ (венозная кровь)","1 день","290 ₽"));
    }


}