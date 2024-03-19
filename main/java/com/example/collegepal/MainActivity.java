package com.example.collegepal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Timer Delay
        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this,Login.class));
            finish();
        },5000);
    }
}