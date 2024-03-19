package com.example.collegepal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Login extends AppCompatActivity{
    private Button signIn;
    private TextInputLayout email;
    private TextInputLayout password;

    private void initComponents() {
        signIn = findViewById(R.id.signIn);
        email = findViewById(R.id.emailInputLayout);
        password = findViewById(R.id.passwordInputLayout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();

        signIn.setOnClickListener(v -> {
            String dataEmail = Objects.requireNonNull(email.getEditText()).getText().toString();
            String dataPassword = Objects.requireNonNull(password.getEditText()).getText().toString();

            if (dataEmail.equals("adrianseptiyadi@gmail.com") && dataPassword.equals("123")) {
                Intent intent = new Intent (Login.this, Tugas.class);
                startActivity(intent);
            }
        });
    }
}
