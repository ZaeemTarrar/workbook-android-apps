package com.example.mydroid3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.mydroid3.databinding.ActivityMainBinding;

public class ApiServiceRolesSection extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Activity activity = this;
    private Button apiGetAllRoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_service_roles_section);
        activity.setTitle("Roles Section");

        apiGetAllRoles = findViewById(R.id.api_get_all_roles);
        apiGetAllRoles.setOnClickListener(view -> {
            startActivity(new Intent(this, RolesSectionGetAllRolesActivity.class));
        });
    }
}

