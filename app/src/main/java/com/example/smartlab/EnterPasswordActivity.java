package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EnterPasswordActivity extends AppCompatActivity {
Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
RadioButton rb1, rb2, rb3, rb4;
ImageButton btnClear;
TextView txt;
List<String> pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpassword);

        pas = new ArrayList<>();
        btnClear = findViewById(R.id.btnClear);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);

        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);

        txt = findViewById(R.id.someone);
        TextView textSkip = findViewById(R.id.enpas_skip);
        textSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationWithDopInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn1.setOnClickListener(this::OnClick);
        btn2.setOnClickListener(this::OnClick);
        btn3.setOnClickListener(this::OnClick);
        btn4.setOnClickListener(this::OnClick);
        btn5.setOnClickListener(this::OnClick);
        btn6.setOnClickListener(this::OnClick);
        btn7.setOnClickListener(this::OnClick);
        btn8.setOnClickListener(this::OnClick);
        btn9.setOnClickListener(this::OnClick);
        btn0.setOnClickListener(this::OnClick);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pas.clear();
                txt.setText("");
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
            }
        });
    }

    private void OnClick(View view){
            Button button=(Button)view;
            pas.add(button.getText().toString());
            txt.setText((String.valueOf(pas)));
            if (pas.size()==1){
                rb1.setChecked(true);
            }
            if (pas.size()==2){
            rb2.setChecked(true);
            }
            if (pas.size()==3){
            rb3.setChecked(true);
            }
            if (pas.size() == 4){
                rb4.setChecked(true);
                Intent intent = new Intent(getApplicationContext(), RegistrationWithDopInfoActivity.class);
                startActivity(intent);
            }
    }
}