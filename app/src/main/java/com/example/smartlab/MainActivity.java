package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Services> services = new ArrayList<Services>();
    ServicesAdapter servicesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        setData();
        servicesAdapter = new ServicesAdapter(this, services);

        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(servicesAdapter);


    }
    void setData(){
        services.add(new Services("ПЦР-тест на определение РНК коронавируса стандратный", "2 дня","1800 ₽"));
        services.add(new Services("Клинический анализ крови с лейкоцитарной формулировкой","1 день","690 ₽"));
        services.add(new Services("Биохимический анализ крови, базовый", "1 день", "2440 ₽"));
        services.add(new Services("СОЭ (венозная кровь)","1 день","290 ₽"));
    }
}