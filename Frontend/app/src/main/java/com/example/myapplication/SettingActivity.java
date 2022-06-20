package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.View.AddItemActivity;
import com.example.myapplication.View.HomepageActivity;
import com.example.myapplication.View.MyProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.Settings);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content,new SettingsFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.HomePage:
                        startActivity(new Intent(SettingActivity.this,HomepageActivity.class));
                        return true;
                    case R.id.AddItem:
                        startActivity(new Intent(SettingActivity.this, AddItemActivity.class));
                        return true;

                    case R.id.Settings:
                        return true;

                    case R.id.Profile:
                        startActivity(new Intent(SettingActivity.this, MyProfileActivity.class));
                        return true;
                }
                return false;
            }
        });
    }
}