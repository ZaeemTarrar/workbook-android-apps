package com.example.mydroid3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mydroid3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Activity activity = this;
    private Button apiServicesSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity.setTitle("Dashboard");

        apiServicesSection = findViewById(R.id.api_services_section);
        apiServicesSection.setOnClickListener(view -> {
            startActivity(new Intent(this, ApiServicesSectionActivity.class));
        });
    }
}