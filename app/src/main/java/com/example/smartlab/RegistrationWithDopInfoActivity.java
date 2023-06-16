package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationWithDopInfoActivity extends AppCompatActivity {
TextView btnSkip;
AutoCompleteTextView textGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_with_dopinfo);

        TextView btnSkip = findViewById(R.id.btnSkipReg);
        textGender = findViewById(R.id.textGender);
        String[] genders = getResources().getStringArray(R.array.gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, genders);
        textGender.setAdapter(adapter);



        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}