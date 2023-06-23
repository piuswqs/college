package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class RegistrationActivity extends AppCompatActivity {
EditText editEmail;
    Button btnAfter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_registration);

        editEmail = findViewById(R.id.editTextEmail);
        Button btnNext = findViewById(R.id.regBut2);
        btnAfter = findViewById(R.id.regBut1);
        btnAfter.setBackgroundResource(R.drawable.transparent_button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CodeForEmailActivity.class);
                startActivity(intent);
            }
        });

        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btnAfter.setEnabled(false);
                btnAfter.setBackgroundResource(R.drawable.transparent_button);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editEmail.getText().length() != 0){
                    if(android.util.Patterns.EMAIL_ADDRESS.matcher(editEmail.getText()).matches()){
                        btnAfter.setEnabled(true);
                        btnAfter.setBackgroundResource(R.drawable.style_button);
                        btnAfter.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getApplicationContext(), CodeForEmailActivity.class);
                                    startActivity(intent);
                                }});}
                    else
                    {btnAfter.setEnabled(false);
                        btnAfter.getResources().getDrawable(R.drawable.transparent_button);}}
                else{
                    btnAfter.setEnabled(false);
                    btnAfter.setBackgroundResource(R.drawable.transparent_button);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}