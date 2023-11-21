package com.geeks.ilia_zusik_hw6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextEmail = findViewById(R.id.edit_text_email);
        EditText editTextPassword = findViewById(R.id.edit_text_password);
        AppCompatButton buttonSign = findViewById(R.id.button_sign);
        ConstraintLayout mainLayout = findViewById(R.id.main_layout);
        TextView textViewWelcomeTextReturn = findViewById(R.id.welcome_text_return);
        buttonSign.setActivated(false);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        textViewWelcomeTextReturn.setOnClickListener(v -> {
            if (mainLayout.getVisibility() == View.GONE) mainLayout.setVisibility(View.VISIBLE);
        });

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editTextEmail.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()) {
                    buttonSign.setActivated(true);
                    buttonSign.setBackgroundResource(R.drawable.bg_sign_button_active);
                } else {
                    buttonSign.setActivated(false);
                    buttonSign.setBackgroundResource(R.drawable.bg_sign_button_inactive);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editTextEmail.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()) {
                    buttonSign.setActivated(true);
                    buttonSign.setBackgroundResource(R.drawable.bg_sign_button_active);
                } else {
                    buttonSign.setActivated(false);
                    buttonSign.setBackgroundResource(R.drawable.bg_sign_button_inactive);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        buttonSign.setOnClickListener(v -> {
            if (buttonSign.isActivated()) {
                if (editTextEmail.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("admin")) {
                    mainLayout.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Нажмите на текст чтобы повторить", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}