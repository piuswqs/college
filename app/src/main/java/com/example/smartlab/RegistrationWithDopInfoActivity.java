package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationWithDopInfoActivity extends AppCompatActivity {
    TextView btnSkip;
    EditText editName, editSurname, editPatronim;
    Button btnCreate;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    public static final String APP_PREFERENCES = "mysettings";
    public static final Boolean APP_PREFERENCES_setBTN = false;
    public static final String APP_PREFERENCES_Name = "NAME";
    public static final String APP_PREFERENCES_Surname = "SURNAME";
    public static final String APP_PREFERENCES_Patronymic = "PATRONYMIC";
    public static final String APP_PREFERENCES_Data = "DATA";
    public static final String APP_PREFERENCES_Gender = "GENDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_with_dopinfo);

        btnCreate = findViewById(R.id.btnCreateMedCard);
        btnSkip = findViewById(R.id.btnSkipReg);
        editName = findViewById(R.id.editNameRegDop);
        editSurname = findViewById(R.id.editSurnameRegDop);
        editPatronim = findViewById(R.id.editPatronymicRegDop);


        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.edit().putBoolean("click",true).apply();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = preferences.edit();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(editName.getText().length() ==0 || editSurname.getText().length()==0 || editPatronim.getText().length()==0)){
                    String stringName, stringSurname, stringPatronym;
                    stringName = editName.getText().toString();
                    stringSurname = editSurname.getText().toString();
                    stringPatronym = editPatronim.getText().toString();
                    editor.putString(APP_PREFERENCES_Name, stringName);
                    editor.putString(APP_PREFERENCES_Surname, stringSurname);
                    editor.putString(APP_PREFERENCES_Patronymic, stringPatronym);
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}