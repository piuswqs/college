package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CodeForEmailActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    ImageButton imgbtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codefromemail);

        editText = (EditText) findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);
        editText3 = findViewById(R.id.edit3);
        editText4 = findViewById(R.id.edit4);
        textView = findViewById(R.id.textSendAgain);
        imgbtn = findViewById(R.id.imgbtnBack);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sec = 60;
                CountDownTimer countDownTimer = new CountDownTimer(sec*1000,1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        textView.setText("Отправить код повторно можно\n будет через "+ (int)(millisUntilFinished/1000) + " секунд");
                        textView.setClickable(false);
                    }

                    @Override
                    public void onFinish() {
                        textView.setText("Отправить код");
                    }
                }.start();
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==1){
                    editText2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==1){
                    editText3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==1){
                    editText4.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if ((editText.getText().toString().matches("1")) && (editText2.getText().toString().matches("1")) && (editText3.getText().toString().matches("1")) && (editText4.getText().toString().matches("1"))){
                    Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                    startActivity(intent);
                    editText.getText().clear();
                    editText2.getText().clear();
                    editText3.getText().clear();
                    editText4.getText().clear();
                }
                else{
                    editText.getText().clear();
                    editText2.getText().clear();
                    editText3.getText().clear();
                    editText4.getText().clear();
                    editText.requestFocus();
                }
            }
        });
    }
}