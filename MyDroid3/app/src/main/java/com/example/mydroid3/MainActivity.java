package com.example.mydroid3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mydroid3.model.RoleModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<RoleModel> roleModelList;
//    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}