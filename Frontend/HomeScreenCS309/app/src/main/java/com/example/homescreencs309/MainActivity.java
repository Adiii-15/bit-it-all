package com.example.homescreencs309;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){


                   case R.id.home:
                       return true;

                   case R.id.search:
                       startActivity(new Intent(getApplicationContext(),Search.class));
                       overridePendingTransition(0,0);
                       return true;

                   case R.id.profile:
                       startActivity(new Intent(getApplicationContext(),MyProfile.class));
                       overridePendingTransition(0,0);
                       return true;

                   case R.id.settings:
                       startActivity(new Intent(getApplicationContext(),Settings.class));
                       overridePendingTransition(0,0);
                       return true;

                   case R.id.fab:
                       startActivity(new Intent(getApplicationContext(),CreateAnAd.class));
                       overridePendingTransition(0,0);
                       return true;

               }


                return false;
            }
        });



    }
}