package com.example.mydroid3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.mydroid3.databinding.ActivityMainBinding;

public class ApiServicesSectionActivity extends AppCompatActivity {

    private ActivityMainBinding binding2;
    private final Activity activity = this;
    private Button rolesSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_services_section);
        activity.setTitle("API Services Section");

        rolesSection = findViewById(R.id.roles_section_button);
        rolesSection.setOnClickListener(view -> {
            startActivity(new Intent(this, ApiServiceRolesSection.class));
        });
    }
}