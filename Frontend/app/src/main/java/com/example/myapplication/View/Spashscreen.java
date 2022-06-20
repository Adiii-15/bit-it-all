package com.example.myapplication.View;
import com.example.myapplication.R;
import com.example.myapplication.RegistrationActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;

public class Spashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spashscreen);
        new Handler().postDelayed(() -> {
            Intent i=new Intent(Spashscreen.this, LoginActivity.class);
            startActivity(i);
            finish();
        }, 1500);
    }
}