package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Services> services = new ArrayList<Services>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

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